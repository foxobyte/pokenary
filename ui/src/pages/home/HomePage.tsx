import React, { Component } from 'react';
import { NavLink } from 'react-router-dom';
import image from '../../images/k1m7dn730g0je3c8dhth5orn7a-d500321e71be3a731cf311d4c624233d.png'
import './homePage.css';
import Carrossel from '../../components/carrossel/Carrossel';

const Home = () => {
    return(
        <div id="home-page">
            <div id="home-page-hero" style={
                {
                    backgroundImage: `url(${image})`,
                    backgroundRepeat: "no-repeat",
                    backgroundPosition: "right 200% top 30%"
                }
            }>
                <div id="home-page-hero-title">
                    POKENARY
                </div>
            </div>
            <nav id="home-page-nav">
                <NavLink to="/pokedex">
                    Pokedex
                </NavLink>
            </nav>
            <div id="home-page-content">
                the home page
                <Carrossel />
            </div>
        </div>
    )
}

export default Home;
