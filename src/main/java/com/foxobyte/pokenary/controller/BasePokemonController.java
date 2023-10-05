package com.foxobyte.pokenary.controller;

import com.foxobyte.pokenary.dao.pokemon.BasePokemon;
import com.foxobyte.pokenary.exception.NotifiableException;
import com.foxobyte.pokenary.service.BasePokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pokemon/base")
@CrossOrigin
public class BasePokemonController {
    @Autowired
    BasePokemonService service;

    @GetMapping
    public ResponseEntity<List<BasePokemon>> getAllBasePokemon() {
        try {
            return new ResponseEntity<>(service.getAllBasePokemon(), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BasePokemon> getBasePokemon(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(service.getBasePokemon(id), HttpStatus.OK);
        } catch (NotifiableException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<List<BasePokemon>> addPokemon(@RequestBody List<BasePokemon> basePokemon) {
        try {
            return new ResponseEntity<>(service.addBasePokemon(basePokemon), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
