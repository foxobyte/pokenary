package com.foxobyte.pokenary.constants;

import com.foxobyte.pokenary.dao.pokemon.IPokemon;

public interface INature {
    IPokemon calculateNature(IPokemon pokemon);
}
