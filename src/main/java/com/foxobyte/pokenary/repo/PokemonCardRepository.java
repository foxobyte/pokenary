package com.foxobyte.pokenary.repo;

import com.foxobyte.pokenary.dao.misc.PokemonCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PokemonCardRepository extends JpaRepository<PokemonCard, Integer> {
    List<PokemonCard> findAllByPokemonId(Integer pokemonId);

    Optional<PokemonCard> findByPokemonId(Integer pokemonId);
}
