package com.foxobyte.pokenary.repo;

import com.foxobyte.pokenary.dao.Move;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoveRepository extends JpaRepository<Move, Integer> {
}
