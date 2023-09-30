package com.foxobyte.pokenary.repo;

import com.foxobyte.pokenary.dao.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
