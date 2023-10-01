package com.foxobyte.pokenary.repo;

import com.foxobyte.pokenary.dao.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
