import React from 'react';
import './battle.css';
import BattleSide from './BattleSide';

const Battle = () => {
    let pokemon = {
        id: 1, 
        name: "pokemon", 
        nationalNumber: 1, 
        pokemonType: ["Grass"], 
        hp: 50, 
        attack: 50, 
        defense: 50, 
        spAttack: 50, 
        spDefense: 50, 
        speed: 50
    }

    return(
        <div className='battle-field-wrapper'>
            <BattleSide attacking={false} pokemon={pokemon}/>
            <BattleSide attacking={true} pokemon={pokemon}/>
        </div>
    )
}

export default Battle;