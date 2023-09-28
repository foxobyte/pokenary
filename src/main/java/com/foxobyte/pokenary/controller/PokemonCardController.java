package com.foxobyte.pokenary.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cards")
public class PokemonCardController {
    @PostMapping
    public void postPokemonCard() {

    }
}
