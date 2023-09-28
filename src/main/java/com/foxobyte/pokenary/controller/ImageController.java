package com.foxobyte.pokenary.controller;

import com.foxobyte.pokenary.dao.Image;
import com.foxobyte.pokenary.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/images")
@CrossOrigin
public class ImageController {
    @Autowired
    ImageService service;

    @GetMapping("/{pokemonId}")
    public ResponseEntity<?> getImage(
            @PathVariable("pokemonId") Integer id
    ) {
        Image image = service.getImage(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-type", image.getType());
        ResponseEntity response = new ResponseEntity(service.getImage(id).getData(), responseHeaders, HttpStatus.OK);
        return response;
//        return new ResponseEntity<>(service.getImage(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> uploadImage(
            @RequestParam("image") MultipartFile file,
            @RequestParam("type") String category,
            @RequestParam("pokemonId") Integer pokemonId
    ) throws IOException {
        try {
            service.uploadImage(file, pokemonId, category);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
