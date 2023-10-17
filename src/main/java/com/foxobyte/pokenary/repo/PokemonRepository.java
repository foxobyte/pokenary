package com.foxobyte.pokenary.repo;

import com.foxobyte.pokenary.constants.Generation;
import com.foxobyte.pokenary.dao.pokemon.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    Pokemon findPokemonByName(String name);

//    @Query(value = "SELECT * FROM BASE_POKEMON WHERE Generation < :generation", nativeQuery = true)
    List<Pokemon> findAllPokemonByGenerationGreaterThanEqual(Generation generation);
}
