package com.foxobyte.pokenary.repo;

import com.foxobyte.pokenary.dao.pokemon.BasePokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasePokemonRepository extends JpaRepository<BasePokemon, Integer> {
    BasePokemon findPokemonByName(String name);
}
