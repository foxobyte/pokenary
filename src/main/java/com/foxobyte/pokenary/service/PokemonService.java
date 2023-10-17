package com.foxobyte.pokenary.service;

import com.foxobyte.pokenary.constants.Generation;
import com.foxobyte.pokenary.dao.pokemon.Pokemon;
import com.foxobyte.pokenary.exception.NotifiableNotFoundException;
import com.foxobyte.pokenary.repo.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PokemonService {
    @Autowired
    PokemonRepository pokemonRepository;
    private Random rand = new Random();

    public Pokemon getPokemon(Integer id) throws Exception {
        Optional<Pokemon> pokemon = pokemonRepository.findById(id);

        if (!pokemon.isPresent()) throw new NotifiableNotFoundException("Pokemon with id " + id + " not found");

        return pokemonRepository.findById(id).get();
    }

    public Pokemon getStarterPokemon(Integer id) throws Exception {
        Optional<Pokemon> pokemon = pokemonRepository.findById(id);

        if (!pokemon.isPresent()) throw new NotifiableNotFoundException("Pokemon with id " + id + " not found");

        return pokemonRepository.findById(id).get();
    }

    public List<Pokemon> getAllPokemon() throws Exception {
        List<Pokemon> basePokemon = pokemonRepository.findAll();

        return basePokemon;
    }

    public Pokemon getRandomPokemon() {
        Integer randomId = rand.nextInt(10) + 827; // ToDo: random can be 0

        return pokemonRepository.findById(randomId).get();
    }

    public Pokemon getRandomPokemonByGeneration(Generation generation) {
        List<Pokemon> pokemon = pokemonRepository.findAllPokemonByGenerationGreaterThanEqual(generation);
        return null;
    }

    public List<Pokemon> addPokemon(List<Pokemon> pokemon) {
        StopWatch watch = new StopWatch();
        watch.start();

        pokemon.stream().forEach(e -> {
            e.setPokemonId(0);
            pokemonRepository.save(e);
        });

        watch.stop();
        System.out.println("Total Time: " + watch.getTotalTimeMillis());

        return pokemonRepository.findAll();
    }
}
