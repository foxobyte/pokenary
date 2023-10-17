import { createRef, useEffect, useRef, useState } from 'react';
import './carousel.css';
import DoubleArrow from '../../icons/DoubleArrow';
import eventThrottle from '../../util/eventThrottle';

interface CarouselProps {
    name: string,
    items: Array<JSX.Element>
}

const Carousel = (props: CarouselProps) => {
    let carousel = createRef<HTMLDivElement>();
    let [items, setItems] = useState(props.items);
    let [index, setIndex] = useState(0);
    let [numberOfItems, setNumberOfItems] = useState(3);

    window.addEventListener('resize', eventThrottle(400, handleSizeSetNumberOfElements))

    useEffect(() => {
        conditionalRenderButtons()
        handleSizeSetNumberOfElements()
    }, [])

    function handleSizeSetNumberOfElements() {
        let width = document.querySelector("#carousel-" + props.name)?.clientWidth;
        let itemWidth = document.querySelector(".carousel-item-wrapper")?.clientWidth;
        let numberOfItems = Math.floor(width! / (itemWidth! + 100));
        console.log(numberOfItems)

        setNumberOfItems(numberOfItems)
        conditionalRenderButtons()
        displayItems()
    }

    function displayItems() {
        let renderedItems = document.querySelectorAll<HTMLElement>(
            "#carousel-" + props.name + " > .carousel-track-wrapper > .carousel-track > .carousel-item-wrapper"
        )

        for (let i = 0; i < index; i++) {
            renderedItems[i].classList.remove("carousel-item-visible")
            renderedItems[i].classList.add("carousel-item-hidden")
        }

        for (let i = index; i < index + numberOfItems; i++) {
            renderedItems[i].classList.add("carousel-item-visible")
            renderedItems[i].classList.remove("carousel-item-hidden")
        }

        for (let i = index + numberOfItems; i < items.length; i++) {
            renderedItems[i].classList.remove("carousel-item-visible")
            renderedItems[i].classList.add("carousel-item-hidden")
        }
    }

    function handleGoForward() {
        if (index + numberOfItems < props.items.length) {
            setIndex(index++)

            let renderedItems = document.querySelectorAll<HTMLElement>(
                "#carousel-" + props.name + " > .carousel-track-wrapper > .carousel-track > .carousel-item-wrapper"
            )
            let showMe = renderedItems[index + numberOfItems];

            showMe.classList.add("carousel-item-enter");
            showMe.classList.remove("carousel-item-hidden");

            let hideMe = renderedItems[index - 1];

            hideMe.classList.add("carousel-item-exit");
            hideMe.classList.remove("carousel-item-visible");

            setTimeout(() => {
                hideMe.classList.remove("carousel-item-exit");
                hideMe.classList.add("carousel-item-hidden");
            }, 300)

            console.log(index)
            return
        }
        console.log("limit")
    }

    function handleGoBack() {
        if (!(index + numberOfItems < props.items.length)) {
            setIndex(index--)
            console.log(index)
            return
        }
        console.log("limit")
    }

    function conditionalRenderButtons() {
        if (items.length <= numberOfItems) {
            let buttons = document.querySelectorAll<HTMLElement>("#carousel-" + props.name + " > .carousel-button");
            buttons[0].style.display = "none";
            buttons[1].style.display = "none";
        } else {
            let buttons = document.querySelectorAll<HTMLElement>("#carousel-" + props.name + " > .carousel-button");
            buttons[0].style.display = "initial";
            buttons[1].style.display = "initial";
        }
    }

    return(
        <div 
            id={"carousel-" + props.name}
            className="carousel-wrapper"
            ref={carousel}
        >
            <button className='carousel-button' onClick={() => handleGoBack()}>
                {<DoubleArrow direction={true} />}
            </button>
            <div className="carousel-track-wrapper">
                <ul className='carousel-track'>
                    {items.map((item, i) => 
                        <li key={i} id={'carousel-' + props.name + '-item-' + i} className='carousel-item-wrapper'>
                            {item}
                        </li>
                    )}
                </ul>
            </div>
            <button className='carousel-button' onClick={() => handleGoForward()}>
                {<DoubleArrow direction={false} />}
            </button>
        </div>
    )
}

export default Carousel;
