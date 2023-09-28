import React, { Component, createRef, MouseEvent } from 'react';
import './pokemonCard.css';
import Pokemon from '../../Pokemon';
import Loading from '../loading/Loading';
// import pokeball from './pokeball.svg';

interface PokemonCardState {
    image: string,
    isLoading: boolean
}

export default class PokemonCard extends Component<Pokemon, PokemonCardState> {
    private card = createRef<HTMLDivElement>();
    private overlay = createRef<HTMLDivElement>();

    constructor(props: Pokemon) {
        super(props);

        this.handleMouseMove = this.handleMouseMove.bind(this);
        this.handleMouseLeave = this.handleMouseLeave.bind(this);

        this.state = {
            image: "",
            isLoading: false
        }
    }

    componentDidMount(): void {
        // this.fetchImage(this.props.id)
    }

    handleMouseMove(e: MouseEvent) {
        this.lightEffect(e);
        this.moveCard(e);
    }

    handleMouseLeave(e: MouseEvent) {
        this.card.current!.style.transform = "";
        this.overlay.current!.style.background = "";
    }

    moveCard(e: MouseEvent) {
        const box = this.card.current!.getBoundingClientRect();
        var x = e.nativeEvent.x;
        var y = e.nativeEvent.y;

        const constraint = 10;

        var rotateY = (x - box.x - (box.width / 2)) / constraint;
        var rotateX = -(y - box.y - (box.height / 2)) / constraint;

        this.card.current!.style.transform = `rotateY(${rotateY}deg) rotateX(${rotateX}deg)`
    }

    lightEffect(e: MouseEvent) {
        const box = this.card.current!.getBoundingClientRect();
        var x = box.width - (e.nativeEvent.x - box.left);
        var y = box.height - (e.nativeEvent.y - box.top);

        this.overlay.current!.style.background = `radial-gradient(circle at ${x}px ${y}px, transparent 65%, rgba(255, 255, 255, .3))`;
    }

    // fetchImage(id: number) {
    //     fetch(`${process.env.REACT_APP_IMAGES_ENDPOINT}/${id}`)
    //         .then(response => response.text())
    //         .then(response => {
    //             this.setState({
    //                 isLoading: false,
    //                 image: `data:image/jpeg; base64,${response}`
    //             })
    //         }).catch(error => {
    //             console.log("caught")
    //         })
    // }

    render() {
        if (this.state.isLoading) {
            return (
                <div className='pokemon-card-wrapper'>
                    <Loading />
                </div>
            )
        }
        return(
            <div 
                className='pokemon-card-wrapper' 
                ref={this.card}
                onMouseMove={this.handleMouseMove} 
                onMouseLeave={this.handleMouseLeave}
            >
                <div className='pokemon-card'>
                    <img 
                        className='pokemon-card-image' 
                        src={`http://localhost:8080/api/v1/images/1`} 
                        alt={this.props.name + " card"}
                    />
                </div>
                <div 
                    className='pokemon-card-overlay'
                    ref={this.overlay}
                >
                </div>
            </div>
        )
    }
}