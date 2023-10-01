package com.foxobyte.pokenary.service;

import com.foxobyte.pokenary.dao.Pokemon;
import com.foxobyte.pokenary.dao.WildPokemon;
import com.foxobyte.pokenary.repo.WildPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WildPokemonService {
    @Autowired
    WildPokemonRepository wildPokemonRepository;
    @Autowired
    PokemonService pokemonService;

    public WildPokemon createWildPokemon(Integer level) {
        WildPokemon wildPokemon = buildWildPokemon(pokemonService.getRandomPokemon(), level);
        return wildPokemon;
    }

    public WildPokemon createWildPokemon(Integer id, Integer level) throws Exception {
        WildPokemon wildPokemon = buildWildPokemon(pokemonService.getPokemon(id), level);
        return wildPokemon;
    }

    public WildPokemon getWildPokemon(Integer id) {
        return wildPokemonRepository.findById(id).get();
    }

    private WildPokemon buildWildPokemon(Pokemon pokemon, Integer level) {
        WildPokemon wildPokemon = new WildPokemon();
        wildPokemon.setPokemon(pokemon);
        wildPokemon.setLevel(level);

        return wildPokemon;
    }
}
