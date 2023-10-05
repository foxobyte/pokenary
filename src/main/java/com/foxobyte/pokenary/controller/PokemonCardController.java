package com.foxobyte.pokenary.controller;

import com.foxobyte.pokenary.dao.misc.PokemonCard;
import com.foxobyte.pokenary.service.PokemonCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/card")
public class PokemonCardController {
    @Autowired
    PokemonCardService service;

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getPokemonCard(
//            @PathVariable("id") Integer id
//    ) {
//        try {
//            return new ResponseEntity<>(service.getPokemonCard(id), HttpStatus.OK);
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/pokemon/{pokemonId}")
    public ResponseEntity<byte[]> getPokemonCards(
            @PathVariable("pokemonId") Integer pokemonId
    ) {
        try {
            PokemonCard pokemonCard = service.getPokemonCard(pokemonId);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", pokemonCard.getFileType());
            return new ResponseEntity(pokemonCard.getImage(), headers, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> uploadPokemonCard(
            @RequestParam("image") MultipartFile file,
            @RequestParam("pokemonId") Integer pokemonId
    ) throws IOException {
        try {
            service.uploadImage(file, pokemonId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
