package com.foxobyte.pokenary.controller;

import com.foxobyte.pokenary.dao.pokemon.PlayerPokemon;
import com.foxobyte.pokenary.service.PlayerPokemonService;
import com.foxobyte.pokenary.service.TestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;



@RestController
@RequestMapping("/api/v1/testing")
public class TestingController {
    @Autowired
    PlayerPokemonService playerPokemonService;
    @Autowired
    TestingService testingService;

    @PostMapping("/player/pokemon")
    public ResponseEntity<PlayerPokemon> createPlayerPokemon(
            @RequestBody PlayerPokemon playerPokemon
    ) {
        try {
            return new ResponseEntity<PlayerPokemon>(
                    playerPokemonService.createPlayerPokemon(playerPokemon),
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
