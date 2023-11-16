import React from 'react';
import PokemonSprite from './PokemonSprite';
import StatsBox from './BattleStatsBox';
import PokemonType from '../../types/PokemonType';
import './battleSide.css';

interface BattleSideProps {
    attacking: boolean,
    pokemon: PokemonType
}

const BattleSide = (props: BattleSideProps) => {
    return(
        <div className='battle-side-wrapper'>
            <div className='battle-side'>
                <StatsBox attacking={props.attacking} name={"pokemon"} level={50} hp={50} gender={true} />
                <PokemonSprite image={`https://img.pokemondb.net/sprites/black-white/anim/${props.attacking ? 'back-normal' : 'normal'}/bulbasaur.gif`} />
            </div>
        </div>
    )
}

export default BattleSide;