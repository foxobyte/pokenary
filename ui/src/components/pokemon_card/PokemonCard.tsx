import React, { Component, createRef, MouseEvent } from 'react';
import './pokemonCard.css';
import PokemonCardType from '../../types/PokemonCardType';

interface PokemonCardState {
    image: string,
    isLoading: boolean
}

interface PokemonCardProps {
    pokemonId: number,
    imageName: string
}

const PokemonCard = (props: PokemonCardType) => {
    let card = createRef<HTMLDivElement>();
    let overlay = createRef<HTMLDivElement>();

    function handleMouseMove(e: MouseEvent) {
        lightEffect(e);
        moveCard(e);
    }

    function handleMouseLeave(e: MouseEvent) {
        card.current!.style.transform = "";
        overlay.current!.style.background = "";
    }

    function moveCard(e: MouseEvent) {
        const box = card.current!.getBoundingClientRect();
        var x = e.nativeEvent.x;
        var y = e.nativeEvent.y;

        const constraint = 10;

        var rotateY = (x - box.x - (box.width / 2)) / constraint;
        var rotateX = -(y - box.y - (box.height / 2)) / constraint;

        card.current!.style.transform = `scale(1.02) rotateY(${rotateY}deg) rotateX(${rotateX}deg)`
        // const box = card.current!.getBoundingClientRect();
        // var origin = {x: box.left + (box.width / 2), y: box.top + (box.height / 2)};
        // var strength = 1;

        // var x = -(origin.x - (e.nativeEvent.x));
        // var y = origin.y - (e.nativeEvent.y);

        // var degreesX = 0;
        // var degreesY = 0;

        // var matrix = [
        //     [1, 0, 0, 0],
        //     [0, 1, 0, 0],
        //     [0, 0, 1, 0],
        //     [0, 0, 0, 1]
        // ]

        // matrix = multiplyMatrix(matrix, rotationMatrices.X(degreesX))
        // matrix = multiplyMatrix(matrix, rotationMatrices.Y(degreesY))

        // card.current!.style.transform = `
        //     matrix3d(
        //         ${matrix[0][0]}, ${matrix[0][1]}, ${matrix[0][2]}, 0,
        //         ${matrix[1][0]}, ${matrix[1][1]}, ${matrix[1][2]}, 0,
        //         ${matrix[2][0]}, ${matrix[2][1]}, ${matrix[2][2]}, 0,
        //         0, 0, 19, 1
        //     )
        // `
    }

    function lightEffect(e: MouseEvent) {
        const box = card.current!.getBoundingClientRect();
        var origin = {x: box.left + (box.width / 2), y: box.top + (box.height / 2)};
        var strength = 1;

        // var x = (origin.x - (e.nativeEvent.x));
        // var y = origin.y - (e.nativeEvent.y);

        // var test = Math.round(Math.sin(y / x) * 100);
        // console.log(test)

        // overlay.current!.style.background = `linear-gradient(${test}deg, transparent 75%, white)`

        var x = box.width - (e.nativeEvent.x - box.left);
        var y = box.height - (e.nativeEvent.y - box.top);

        overlay.current!.style.background = `radial-gradient(circle at ${x}px ${y}px, transparent 65%, rgba(255, 255, 255, .3))`;
    }

    return(
        <div 
            className='basePokemon-card-wrapper'
            ref={card}
            onMouseMove={handleMouseMove} 
            onMouseLeave={handleMouseLeave}
        >
            <div className='basePokemon-card'>
                <img 
                    className='basePokemon-card-image'
                    src={`http://localhost:8080/api/v1/cards/basePokemon/1`}
                    // alt={props.imageName + " card"}
                />
            </div>
            <div 
                className='basePokemon-card-overlay'
                ref={overlay}
            >
                {props.pokemonId}
            </div>
        </div>
    )
}

export default PokemonCard;
