package com.foxobyte.pokenary.repo;

import com.foxobyte.pokenary.dao.PokemonSprite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PokemonSpriteRepository extends JpaRepository<PokemonSprite, Integer> {
    List<PokemonSprite> findAllByPokemonId(Integer pokemonId);

    Optional<PokemonSprite> findByPokemonId(Integer pokemonId);
}
