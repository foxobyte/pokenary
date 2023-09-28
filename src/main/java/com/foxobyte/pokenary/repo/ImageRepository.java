package com.foxobyte.pokenary.repo;

import com.foxobyte.pokenary.dao.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    Optional<Image> findByPokemonId(Integer pokemonId);
}
