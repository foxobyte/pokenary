import React from 'react';
import './pokemonSprite.css';

interface PokemonSpriteProps {
    image: string
}

const PokemonSprite = (props: PokemonSpriteProps) => {
    return(
        <div className='basePokemon-sprite' style={{
            backgroundImage: `url(${props.image})`
        }}>
        
        </div>
    )
}

export default PokemonSprite;