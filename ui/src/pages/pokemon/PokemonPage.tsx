import React, { Component } from 'react';
import { useParams, useResolvedPath, resolvePath } from 'react-router';
import Pokemon from '../../Pokemon';

function fetchPokemon(name: string) {
    fetch("http://localhost:8080/api/v1/pokemon/" + name)
        .then(result => result.json())
        .then(result => {return result}, 
            (error) => console.log(error));
}

const PokemonPage = (props: any) => {
    const params = useParams()
    // window.history.replaceState(null, "New Page Title", "/pathname/goes/here")

    if (Number.isNaN(parseInt(params.pokemon!))) {
        console.log("nan")
    } else {
        console.log("number")
    }
    
    return (
        <div>
            Pokemon Page
        </div>
    )
}

export default PokemonPage