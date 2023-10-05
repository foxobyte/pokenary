package com.foxobyte.pokenary.service;

import com.foxobyte.pokenary.dao.pokemon.BasePokemon;
import com.foxobyte.pokenary.exception.NotifiableNotFoundException;
import com.foxobyte.pokenary.repo.BasePokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BasePokemonService {
    @Autowired
    BasePokemonRepository basePokemonRepository;

    public BasePokemon getBasePokemon(Integer id) throws Exception {
        Optional<BasePokemon> pokemon = basePokemonRepository.findById(id);

        if (!pokemon.isPresent()) throw new NotifiableNotFoundException("Pokemon with id " + id + " not found");

        return basePokemonRepository.findById(id).get();
    }

    public BasePokemon getStarterBasePokemon(Integer id) throws Exception {
        Optional<BasePokemon> pokemon = basePokemonRepository.findById(id);

//        com.foxobyte.pokenary.constants.Pokemon.BULBASAUR;
//        com.foxobyte.pokenary.constants.Pokemon.CHARMANDER;
//        com.foxobyte.pokenary.constants.Pokemon.SQUIRTLE;
//        com.foxobyte.pokenary.constants.Pokemon.CHIKORITA;
//        com.foxobyte.pokenary.constants.Pokemon.CYNDAQUIL;
//        com.foxobyte.pokenary.constants.Pokemon.TOTODILE;
//        com.foxobyte.pokenary.constants.Pokemon.TREECKO
//        com.foxobyte.pokenary.constants.Pokemon.TORCHIC;
//        com.foxobyte.pokenary.constants.Pokemon.MUDKIP;
//        com.foxobyte.pokenary.constants.Pokemon.TURTWIG;
//        com.foxobyte.pokenary.constants.Pokemon.CHIMCHAR;
//        com.foxobyte.pokenary.constants.Pokemon.PIPLUP;
//        com.foxobyte.pokenary.constants.Pokemon.SNIVY;
//        com.foxobyte.pokenary.constants.Pokemon.TEPIG;
//        com.foxobyte.pokenary.constants.Pokemon.OSHAWOTT;
//        com.foxobyte.pokenary.constants.Pokemon.CHESPIN;
//        com.foxobyte.pokenary.constants.Pokemon.FENNEKIN;
//        com.foxobyte.pokenary.constants.Pokemon.FROAKIE;
//        com.foxobyte.pokenary.constants.Pokemon.ROWLET;
//        com.foxobyte.pokenary.constants.Pokemon.LITTEN;
//        com.foxobyte.pokenary.constants.Pokemon.POPPLIO;
//        com.foxobyte.pokenary.constants.Pokemon.GROOKEY;
//        com.foxobyte.pokenary.constants.Pokemon.SCORBUNNY;
//        com.foxobyte.pokenary.constants.Pokemon.SOBBLE;
//        com.foxobyte.pokenary.constants.Pokemon.SPRIGATITO;
//        com.foxobyte.pokenary.constants.Pokemon.FUECOCO;
//        com.foxobyte.pokenary.constants.Pokemon.QUAXLY;

        if (!pokemon.isPresent()) throw new NotifiableNotFoundException("Pokemon with id " + id + " not found");

        return basePokemonRepository.findById(id).get();
    }

    public List<BasePokemon> getAllBasePokemon() throws Exception {
        List<BasePokemon> basePokemon = basePokemonRepository.findAll();

        return basePokemon;
    }

    public BasePokemon getRandomBasePokemon() {
        Random rand = new Random();
        Integer randomId = rand.nextInt(10) + 827; // ToDo: random can be 0

        return basePokemonRepository.findById(randomId).get();
    }

    public List<BasePokemon> addBasePokemon(List<BasePokemon> basePokemon) {
        StopWatch watch = new StopWatch();
        watch.start();

        basePokemon.stream().forEach(e -> {
            e.setBasePokemonId(0);
            basePokemonRepository.save(e);
        });

        watch.stop();
        System.out.println("Total Time: " + watch.getTotalTimeMillis());

        return basePokemonRepository.findAll();
    }
}
