package com.foxobyte.pokenary.controller;

import com.foxobyte.pokenary.dao.Player;
import com.foxobyte.pokenary.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        try {
            return new ResponseEntity<>(playerService.createPlayer(player), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Player> getPlayer(@RequestParam Long id) {
        try {
            return new ResponseEntity<>(playerService.getPlayer(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
