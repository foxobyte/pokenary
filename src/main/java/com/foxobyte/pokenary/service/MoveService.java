package com.foxobyte.pokenary.service;

import com.foxobyte.pokenary.dao.Move;
import com.foxobyte.pokenary.repo.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoveService {
    @Autowired
    MoveRepository moveRepository;

    public List<Move> createMoves(List<Move> moves) {
        moves.stream().forEach(move -> {
            moveRepository.save(move);
        });

        return moveRepository.findAll();
    }

    public Move getMove(Integer moveId) {
        return moveRepository.findById(moveId).get();
    }

    public List<Move> getAllMoves() {
        return moveRepository.findAll();
    }

    public Move updateMove(Move move) {
        return moveRepository.save(move);
    }
}
