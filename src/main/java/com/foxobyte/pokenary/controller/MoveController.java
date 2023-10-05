package com.foxobyte.pokenary.controller;

import com.foxobyte.pokenary.dao.Move;
import com.foxobyte.pokenary.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/move")
public class MoveController {
    @Autowired
    MoveService moveService;

    @PostMapping
    public ResponseEntity<List<Move>> createMoves(@RequestBody List<Move> moves) {
        try {
            return new ResponseEntity<>(moveService.createMoves(moves), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
