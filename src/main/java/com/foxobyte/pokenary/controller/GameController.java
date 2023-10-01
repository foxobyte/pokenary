package com.foxobyte.pokenary.controller;

import com.foxobyte.pokenary.dao.Game;
import com.foxobyte.pokenary.dao.Player;
import com.foxobyte.pokenary.exception.GameHasStartedException;
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
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/join")
    public ResponseEntity<Game> joinGame(
            @RequestParam("gameId") Long gameId,
            @RequestParam("playerPokemonId") Long playerPokemonId
    ) {
        try {
            return new ResponseEntity<>(service.joinGame(gameId, playerPokemonId), HttpStatus.OK);
        } catch (GameHasStartedException e) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Game has already started");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
