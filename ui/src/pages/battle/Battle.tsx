import React from 'react';
import './battle.css';
import BattlePatch from './BattlePatch';
import PokemonSprite from './PokemonSprite';

const Battle = () => {
    let image = "https://img.pokemondb.net/sprites/black-white/anim/normal/bulbasaur.gif"
    return(
        <div className='battle-field-wrapper'>
            <div id="battle-field-defending" className='battle-patch-wrapper'>
                <PokemonSprite image={image} />
                <BattlePatch />
            </div>
            <div id="battle-field-attacking" className='battle-patch-wrapper'>
                <PokemonSprite image={image} />
                <BattlePatch />
            </div>
        </div>
    )
}

export default Battle;