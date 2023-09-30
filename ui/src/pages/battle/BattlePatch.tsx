import React from 'react';
import PokemonSprite from './PokemonSprite';
import './battlePatch.css';

const BattlePatch = () => {
    return(
        <div className='battle-patch-wrapper'>
            <PokemonSprite image="https://img.pokemondb.net/sprites/black-white/anim/back-normal/bulbasaur.gif"/>
            <div className='battle-patch'>

            </div>
        </div>
    )
}

export default BattlePatch;