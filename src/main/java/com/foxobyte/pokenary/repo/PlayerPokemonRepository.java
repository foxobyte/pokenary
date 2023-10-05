package com.foxobyte.pokenary.repo;

import com.foxobyte.pokenary.dao.pokemon.PlayerPokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerPokemonRepository extends JpaRepository<PlayerPokemon, Long>{
}
