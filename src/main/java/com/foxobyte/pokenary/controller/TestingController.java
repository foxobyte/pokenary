package com.foxobyte.pokenary.controller;

import com.foxobyte.pokenary.constants.Generation;
import com.foxobyte.pokenary.dao.pokemon.EffortValues;
import com.foxobyte.pokenary.dao.pokemon.PlayerPokemon;
import com.foxobyte.pokenary.service.PlayerPokemonService;
import com.foxobyte.pokenary.service.PokemonService;
import com.foxobyte.pokenary.service.TestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;



@RestController
@RequestMapping("/api/v1/testing")
@Validated
public class TestingController {
    @Autowired
    PokemonService pokemonService;
    @Autowired
    PlayerPokemonService playerPokemonService;
    @Autowired
    TestingService testingService;

    @PostMapping("/player/pokemon")
    public ResponseEntity<PlayerPokemon> createPlayerPokemon(
            @RequestParam Generation generation,
            @RequestBody PlayerPokemon playerPokemon
    ) {
        try {
            return new ResponseEntity<PlayerPokemon>(
                    playerPokemonService.createPlayerPokemon(generation, playerPokemon),
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public void getRandomPokemon(@RequestParam("generation") Generation generation) {
        pokemonService.getRandomPokemonByGeneration(generation);
    }
}
