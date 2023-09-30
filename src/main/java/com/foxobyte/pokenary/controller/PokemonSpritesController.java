package com.foxobyte.pokenary.controller;

import com.foxobyte.pokenary.dao.PokemonSprite;
import com.foxobyte.pokenary.service.PokemonSpriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/sprites")
public class PokemonSpritesController {
    @Autowired
    PokemonSpriteService service;

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
    public ResponseEntity<?> getPokemonCards(
            @PathVariable("pokemonId") Integer pokemonId
    ) {
        try {
            PokemonSprite sprite = service.getPokemonSprites(pokemonId);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", sprite.getFileType());
            return new ResponseEntity(sprite.getImage(), headers, HttpStatus.OK);
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
