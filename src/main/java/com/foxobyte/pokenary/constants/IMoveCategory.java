package com.foxobyte.pokenary.constants;

import com.foxobyte.pokenary.dao.pokemon.IPokemon;
import com.foxobyte.pokenary.dao.Move;

public interface IMoveCategory {
    void move(IPokemon attackingPokemon, IPokemon defendingPokemon, Move move);
}
