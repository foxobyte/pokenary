package com.foxobyte.pokenary.controller;

import com.foxobyte.pokenary.dao.Pokemon;
import com.foxobyte.pokenary.exception.NotifiableException;
import com.foxobyte.pokenary.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pokemon")
@CrossOrigin
public class PokemonController {
    @Autowired
    PokemonService service;

//    @GetMapping
//    public ResponseEntity<Pokemon[]> getAllPokemon() {
//        try {
//            return new ResponseEntity<>(service.getAllPokemon(), HttpStatus.OK);
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(service.getPokemon(id), HttpStatus.OK);
        } catch (NotifiableException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping
//    public ResponseEntity<Pokemon> addPokemon(@RequestBody Pokemon pokemon) {
//        try {
//            return new ResponseEntity<>(service.addPokemon(pokemon), HttpStatus.CREATED);
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping
    public ResponseEntity<List<Pokemon>> addPokemon(@RequestBody List<Pokemon> pokemon) {
        try {
            return new ResponseEntity<>(service.addPokemon(pokemon), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/jpa")
    public ResponseEntity<List<Pokemon>> addJPAPokemon(@RequestBody List<Pokemon> pokemon) {
        try {
            return new ResponseEntity<>(service.addJPAPokemon(pokemon), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/time")
    public void timeAddPokemon(@RequestBody List<Pokemon> pokemon) {
        try {
            service.timeAddPokemon(pokemon);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
