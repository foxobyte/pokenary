import React, { Component, useEffect, useState } from 'react';
import { NavLink } from 'react-router-dom';
import image from '../../images/k1m7dn730g0je3c8dhth5orn7a-d500321e71be3a731cf311d4c624233d.png'
import './homePage.css';
import PokedexPage from '../pokedex/PokedexPage';
import Carousel from '../../components/carousel/Carousel';
import PokemonCard from '../../components/pokemon_card/PokemonCard';
import PokemonCardType from '../../types/PokemonCardType';

const Home = () => {
    let basePokemon: Array<JSX.Element> = [
        <PokemonCard pokemonId={1}/>,
        <PokemonCard pokemonId={2}/>,
        <PokemonCard pokemonId={3}/>,
        <PokemonCard pokemonId={4}/>,
        <PokemonCard pokemonId={5}/>,
        <PokemonCard pokemonId={6}/>
    ]

    return(
        <div id="home-page">
            <div className='dot'>
            </div>
            <div id="home-page-hero" style={
                {
                    backgroundImage: `url(${image})`,
                    backgroundRepeat: "no-repeat",
                    backgroundPosition: "right 200% top 30%"
                }
            }>
                <div id="home-page-hero-title">
                    PICKLES
                </div>
            </div>
            <nav id="home-page-nav">
                <NavLink to="/pokedex">
                    Pokedex
                </NavLink>
            </nav>
            <div id="home-page-content">
                the home page
                <Carousel name="cards" items={basePokemon} />
            </div>
        </div>
    )
}

export default Home;
