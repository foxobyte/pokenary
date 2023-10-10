package com.foxobyte.pokenary.service;

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
    PokemonRepository basePokemonRepository;
    private Random rand = new Random();

    public Pokemon getPokemon(Integer id) throws Exception {
        Optional<Pokemon> pokemon = basePokemonRepository.findById(id);

        if (!pokemon.isPresent()) throw new NotifiableNotFoundException("Pokemon with id " + id + " not found");

        return basePokemonRepository.findById(id).get();
    }

    public Pokemon getStarterPokemon(Integer id) throws Exception {
        Optional<Pokemon> pokemon = basePokemonRepository.findById(id);

        if (!pokemon.isPresent()) throw new NotifiableNotFoundException("Pokemon with id " + id + " not found");

        return basePokemonRepository.findById(id).get();
    }

    public List<Pokemon> getAllPokemon() throws Exception {
        List<Pokemon> basePokemon = basePokemonRepository.findAll();

        return basePokemon;
    }

    public Pokemon getRandomPokemon() {
        Integer randomId = rand.nextInt(10) + 827; // ToDo: random can be 0

        return basePokemonRepository.findById(randomId).get();
    }

    public List<Pokemon> addPokemon(List<Pokemon> pokemon) {
        StopWatch watch = new StopWatch();
        watch.start();

        pokemon.stream().forEach(e -> {
            e.setPokemonId(0);
            basePokemonRepository.save(e);
        });

        watch.stop();
        System.out.println("Total Time: " + watch.getTotalTimeMillis());

        return basePokemonRepository.findAll();
    }
}
