package com.foxobyte.pokenary.constants;

import com.foxobyte.pokenary.dao.Game;
import com.foxobyte.pokenary.dao.Move;
import com.foxobyte.pokenary.dao.pokemon.IPokemon;
import com.foxobyte.pokenary.dao.pokemon.IStatValues;

public interface IGeneration {
    int calculateDamage(IPokemon attackingPokemon, IPokemon defendingPokemon, Move move, Game game);

    IPokemon calculatePokemonStats(IPokemon pokemon);
}
