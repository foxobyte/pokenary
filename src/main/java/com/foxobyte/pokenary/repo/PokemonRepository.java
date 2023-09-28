package com.foxobyte.pokenary.repo;

import com.foxobyte.pokenary.dao.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
}
