import React, { Component } from 'react';
import './pokemonCard.css';

type PokemonCardProps = {
    id: number,
    name: string,
    HP: number,
    image: string,
    card: object,
    overlay: object
}

export default class PokemonCard extends Component {
    constructor(props: PokemonCardProps) {
        super(props);

        this.state = {
            name: props.name,
            image: props.image,
            card: React.createRef(),
            overlay: React.createRef()
        }

        this.handleMouseMove = this.handleMouseMove.bind(this);
        this.handleMouseLeave = this.handleMouseLeave.bind(this);
    }

    componentDidMount() {
        // this.setState({
        //     name: "omg a name!",
        //     image: this.props.image
        // })
    }

    handleMouseMove(e: Event) {
        this.lightEffect(e);
        this.moveCard(e);
    }

    handleMouseLeave(e: Event) {
        this.state.card.current.style.transform = "";
        this.overlay.current.style.background = "";
    }

    moveCard(e: MouseEvent) {
        const box = this.card.current.getBoundingClientRect();
        var x = e.nativeEvent.x;
        var y = e.nativeEvent.y;

        const constraint = 10;

        var rotateY = (x - box.x - (box.width / 2)) / constraint;
        var rotateX = -(y - box.y - (box.height / 2)) / constraint;

        this.card.current.style.transform = `rotateY(${rotateY}deg) rotateX(${rotateX}deg)`
    }

    lightEffect(e) {
        const box = this.card.current.getBoundingClientRect();
        var x = box.width - (e.nativeEvent.x - box.left);
        var y = box.height - (e.nativeEvent.y - box.top);

        this.overlay.current.style.background = `radial-gradient(circle at ${x}px ${y}px, transparent 65%, rgba(255, 255, 255, .3))`;
    }

    render() {
        return(
            <div 
                className='pokemon-card' 
                ref={this.card}
                onMouseMove={this.handleMouseMove} 
                onMouseLeave={this.handleMouseLeave}
            >
                <img 
                    className='pokemon-card-image' 
                    src={this.state.image} 
                />
                <div 
                    className='pokemon-card-overlay'
                    ref={this.overlay}
                >

                </div>
            </div>
        )
    }
}