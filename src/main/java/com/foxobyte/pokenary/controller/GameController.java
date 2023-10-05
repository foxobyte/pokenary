package com.foxobyte.pokenary.controller;

import com.foxobyte.pokenary.dao.Game;
import com.foxobyte.pokenary.exception.GameHasStartedException;
import com.foxobyte.pokenary.exception.AlreadyInGameException;
import com.foxobyte.pokenary.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/game")
public class GameController {
    @Autowired
    GameService service;

    @PostMapping("/create")
    public ResponseEntity<Game> createGame(
//            @RequestHeader String key
    ) {
        try {
            return new ResponseEntity<>(service.createGame(), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Game> getGame(
            @RequestParam("gameId") Long gameId
    ) {
        try {
            return new ResponseEntity<>(service.getGame(gameId), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/join")
    public ResponseEntity<Game> joinGame(
            @RequestParam("gameId") Long gameId,
            @RequestParam("playerId") Long playerId,
            @RequestParam("playerPokemonId") Long playerPokemonId
    ) {
        try {
            return new ResponseEntity<>(service.joinGame(gameId, playerId, playerPokemonId), HttpStatus.OK);
        } catch (GameHasStartedException | AlreadyInGameException e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_MODIFIED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/start")
    public ResponseEntity<Game> startGame(
            @RequestParam("gameId") Long gameId
    ) {
        try {
            return new ResponseEntity<>(service.startGame(gameId), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/move")
    public ResponseEntity<Game> move(
            @RequestParam("gameId") Long gameId,
            @RequestParam("playerPokemonId") Long playerPokemonId,
            @RequestParam("moveId") Integer moveId
    ) {
        try {
            return new ResponseEntity<>(service.move(gameId, playerPokemonId, moveId), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
