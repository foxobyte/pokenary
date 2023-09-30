package com.foxobyte.pokenary.service;

import com.foxobyte.pokenary.dao.Pokemon;
import com.foxobyte.pokenary.dao.PokemonJPA;
import com.foxobyte.pokenary.exception.NotifiableNotFoundException;
import com.foxobyte.pokenary.repo.PokemonJPARepository;
import com.foxobyte.pokenary.repo.PokemonRepository;
import com.foxobyte.pokenary.util.TimeComplexityChart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.stage.StageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PokemonService {
    @Autowired
    PokemonRepository repository;
    @Autowired
    PokemonJPARepository jpaRepository;

    public Pokemon getPokemon(Integer id) throws Exception {
        Optional<Pokemon> pokemon = repository.findById(id);

        if (!pokemon.isPresent()) throw new NotifiableNotFoundException("Pokemon with id " + id + " not found");

//        pokemon.get().setType();
        return repository.findById(id).get();
    }

//    public Pokemon[] getAllPokemon() throws Exception {
//        Pokemon[] pokemon = Pokemon.values();
//
//        return pokemon;
//    }

    public Pokemon getRandomPokemon() {
        Random rand = new Random();
        Integer randomId = rand.nextInt(1000);
        return repository.findById(randomId).get();
    }

    public List<Pokemon> addPokemon(List<Pokemon> pokemon) {
        StopWatch watch = new StopWatch();
        watch.start();

        pokemon.stream().forEach(e -> {
            e.setId(0);
            repository.save(e);
        });

        watch.stop();
        System.out.println("Total Time: " + watch.getTotalTimeMillis());
        return repository.findAll();
    }

    public List<Pokemon> addJPAPokemon(List<Pokemon> pokemon) {
        List<PokemonJPA> pokemonJpa = pokemon.stream().map(PokemonJPA::new).collect(Collectors.toList());

        StopWatch watch = new StopWatch();
        watch.start();

        pokemonJpa.stream().forEach(e -> {
            e.setId(0);
            jpaRepository.save(e);
        });

        watch.stop();
        System.out.println("Total Time: " + watch.getTotalTimeMillis());
        return repository.findAll();
    }

    public void timeAddPokemon(List<Pokemon> pokemon) {
        List<Long> results = new ArrayList<>();
        List<Long> jpaResults = new ArrayList<>();

        for (int i = 1190; i < pokemon.size(); i++) {
            StopWatch watch = new StopWatch();
            watch.start();

            for (int j = 0; j < i; j++) {
                repository.save(pokemon.get(j));
            }

            watch.stop();
            Long result = watch.getTotalTimeMillis();
            results.add(result);
            System.out.println("Add " + i + " pokemon ran in " + result);
            repository.deleteAll();
        }

        List<PokemonJPA> pokemonJpa = pokemon.stream().map(PokemonJPA::new).collect(Collectors.toList());

        for (int i = 1190; i < pokemon.size(); i++) {
            StopWatch watch = new StopWatch();
            watch.start();

            for (int j = 0; j < i; j++) {
                jpaRepository.save(pokemonJpa.get(j));
            }

            watch.stop();
            Long result = watch.getTotalTimeMillis();
            jpaResults.add(result);
            System.out.println("Add " + i + " pokemon ran in " + result);
            jpaRepository.deleteAll();
        }

        System.out.println(Platform.isAccessibilityActive());

        new Thread(new Runnable() {
            @Override
            public void run() {
                new JFXPanel();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            TimeComplexityChart timeComplexityChart = new TimeComplexityChart();
                            timeComplexityChart.setTitle("JPA Auto vs Custom");
                            timeComplexityChart.addSeries(results, "Custom Imp");
                            timeComplexityChart.addSeries(jpaResults, "JPA Imp");
                            timeComplexityChart.start(StageBuilder.create().build());
                        } catch (Exception e) {
                            System.out.println("");
                        }
                    }
                });
            }
        }).start();

    }
}
