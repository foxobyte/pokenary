package com.foxobyte.pokenary.constants;

import com.foxobyte.pokenary.dao.pokemon.IPokemon;

public interface IGeneration {
    IPokemon calculatePokemonStats(IPokemon pokemon);
}
