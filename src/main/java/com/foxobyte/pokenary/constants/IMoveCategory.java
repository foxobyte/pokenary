package com.foxobyte.pokenary.constants;

import com.foxobyte.pokenary.dao.pokemon.IPokemon;

public interface IMoveCategory {
    void move(IPokemon attackingPokemon, IPokemon defendingPokemon, com.foxobyte.pokenary.dao.Move move);
}
