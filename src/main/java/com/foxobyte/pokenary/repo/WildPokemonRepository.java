package com.foxobyte.pokenary.repo;

import com.foxobyte.pokenary.dao.WildPokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WildPokemonRepository extends JpaRepository<WildPokemon, Integer> {
}