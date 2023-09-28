package com.foxobyte.pokenary.service;

import com.foxobyte.pokenary.dao.Pokemon;
import com.foxobyte.pokenary.exception.NotifiableNotFoundException;
import com.foxobyte.pokenary.repo.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {
    @Autowired
    PokemonRepository repository;

    public List<Pokemon> getAllPokemon() throws Exception {
        List<Pokemon> pokemon = repository.findAll();

        if (pokemon.isEmpty()) throw new NotifiableNotFoundException("No pokemon found");

        return pokemon;
    }

    public Pokemon getPokemon(Integer id) throws Exception {
        Optional<Pokemon> pokemon = repository.findById(id);

        if (!pokemon.isPresent()) throw new NotifiableNotFoundException("Pokemon with id " + id + " not found");

        return repository.findById(id).get();
    }

    public Pokemon addPokemon(Pokemon pokemon) {
        pokemon.setId(0);
        return repository.save(pokemon);
    }

    public Pokemon updatePokemon(Pokemon pokemon) {
        return repository.save(pokemon);
    }

    public void deletePokemon(Integer id) throws Exception {
        Optional<Pokemon> pokemon = repository.findById(id);

        if (!pokemon.isPresent()) throw new NotifiableNotFoundException("Pokemon not found with id " + id);

        repository.delete(pokemon.get());
    }
}
