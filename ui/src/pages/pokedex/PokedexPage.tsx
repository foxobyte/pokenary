import React, { Component, useState, useEffect } from 'react';
import { useParams } from 'react-router';
import PokemonCard from '../../components/pokemon_card/PokemonCard';
import './pokedexPage.css';
import Pokemon from '../../types/PokemonType';

interface PokedexProps {

}

interface PokedexState {
    search: string,
    pokemon: Array<Pokemon>,
    isLoaded: boolean,
    error: string
}

const PokedexPage = (props: PokedexProps) => {
    let [pokemon, setPokemon] = useState<Pokemon[]>([])

    useEffect(() => {
        fetch("http://localhost:8080/api/v1/pokemon")
            .then(response => response.json())
            .then(result => setPokemon(result))
    }, [])

    useEffect(() => {
        console.log("updated")
    })

    return(
        <div id='pokedex-page'>
            {pokemon.map(pokemon =>
                <div>
                    <img src={"https://img.pokemondb.net/sprites/black-white/anim/back-normal/" + pokemon.name.toLowerCase() + ".gif"}/>
                </div>)
            }
        </div>
    )
}

export default PokedexPage;
