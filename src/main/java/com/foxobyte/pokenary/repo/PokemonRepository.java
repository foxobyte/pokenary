package com.foxobyte.pokenary.repo;

import com.foxobyte.pokenary.dao.pokemon.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    Pokemon findPokemonByName(String name);
}
