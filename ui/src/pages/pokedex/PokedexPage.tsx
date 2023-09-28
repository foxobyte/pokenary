import React, { Component } from 'react';
import { useParams } from 'react-router';
import Pokemon from '../../Pokemon';
import PokemonCard from '../../components/pokemon_card/PokemonCard';
import './pokedexPage.css';

interface PokedexProps {
    
}

interface PokedexState {
    search: string,
    pokemon: Array<Pokemon>,
    isLoaded: boolean,
    error: string
}

export default class PokedexPage extends Component<PokedexProps, PokedexState> {
    constructor(props: PokedexProps) {
        super(props);

        this.state = {
            search: "",
            pokemon: [], // immute
            isLoaded: false,
            error: ""
        }
    }

    componentDidMount(): void {
        this.fetchPokemon()
    }

    fetchPokemon() {
        fetch(`${process.env.REACT_APP_POKEMON_ENDPOINT}`)
            .then(result => result.json())
            .then(result => {
                this.setState({
                    isLoaded: true,
                    pokemon: result
                })
            }, (error) => {
                this.setState({
                    isLoaded: true,
                    error: error
                })
            });
    }

    render() {
        return(
            <div id='pokedex-page'>
                {this.state.pokemon.map(pokemon => {
                    return <PokemonCard 
                        key={pokemon.id}
                        id={pokemon.id} 
                        name={pokemon.name}
                        nationalNumber={pokemon.nationalNumber}
                        type={pokemon.type}
                        attack={pokemon.attack}
                        defense={pokemon.defense}
                        hp={pokemon.hp}
                        spAttack={pokemon.spAttack}
                        spDefense={pokemon.spDefense}
                        speed={pokemon.speed}
                    />
                })}
            </div>
        )
    }
}