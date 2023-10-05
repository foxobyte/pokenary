import React, { Component, useState, useEffect } from 'react';
import { useParams } from 'react-router';
import PokemonCard from '../../components/pokemon_card/PokemonCard';
import './pokedexPage.css';
import Pokemon from '../../types/PokemonType';

interface PokedexProps {

}

interface PokedexState {
    search: string,
    basePokemon: Array<Pokemon>,
    isLoaded: boolean,
    error: string
}

const PokedexPage = (props: PokedexProps) => {
    let [basePokemon, setPokemon] = useState<Pokemon[]>([])

    useEffect(() => {
        fetch("http://localhost:8080/api/v1/basePokemon")
            .then(response => response.json())
            .then(result => setPokemon(result))
    }, [])

    useEffect(() => {
        console.log("updated")
    })

    return(
        <div id='pokedex-page'>
            {basePokemon.map(basePokemon =>
                <div>
                    <img src={"https://img.pokemondb.net/sprites/black-white/anim/back-normal/" + basePokemon.name.toLowerCase() + ".gif"}/>
                </div>)
            }
        </div>
    )
}

export default PokedexPage;
