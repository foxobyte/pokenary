package com.foxobyte.pokenary.repo;

import com.foxobyte.pokenary.dao.PlayerPokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerPokemonRepository extends JpaRepository<PlayerPokemon, Long>{
}
