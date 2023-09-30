package com.foxobyte.pokenary.repo;

import com.foxobyte.pokenary.dao.PokemonJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonJPARepository extends JpaRepository<PokemonJPA, Integer> {
}
