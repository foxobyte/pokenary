package com.foxobyte.pokenary.service;

import com.foxobyte.pokenary.constants.Nature;
import com.foxobyte.pokenary.dao.pokemon.IndividualValues;
import com.foxobyte.pokenary.dao.Move;
import com.foxobyte.pokenary.dao.pokemon.Pokemon;
import com.foxobyte.pokenary.dao.pokemon.WildPokemon;
import com.foxobyte.pokenary.repo.IndividualValuesRepository;
import com.foxobyte.pokenary.repo.WildPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.foxobyte.pokenary.util.PokemonRNG.*;
import static com.foxobyte.pokenary.util.PokemonCalculator.*;

@Service
public class WildPokemonService {
    @Autowired
    WildPokemonRepository wildPokemonRepository;
    @Autowired
    IndividualValuesRepository individualValuesRepository;
    @Autowired
    PokemonService pokemonService;
    @Autowired
    MoveService moveService;
    private Random random = new Random();

    public WildPokemon createWildPokemon(Integer level) {
        IndividualValues individualValues = getRandomIndividualValues();
        individualValuesRepository.save(individualValues);
        Nature nature = getRandomNature();
        WildPokemon wildPokemon = buildWildPokemon(pokemonService.getRandomPokemon(), level, individualValues, nature);

        List<Integer> availableMoves = new ArrayList<>(wildPokemon.getPokemon().getMovesLearnedAtLevel().entrySet().stream().filter(e -> e.getValue() <= wildPokemon.getLevel()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).keySet());
        Set<Move> moves = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            Integer availableMove = availableMoves.get(random.nextInt(availableMoves.size()));
            moves.add(moveService.getMove(availableMove));
            availableMoves.remove(availableMove);
        }
        wildPokemon.setMoves(moves);

        return wildPokemonRepository.save(wildPokemon);
    }

    public WildPokemon createWildPokemon(Integer id, Integer level) throws Exception {
        IndividualValues individualValues = getRandomIndividualValues();
        individualValuesRepository.save(individualValues);
        Nature nature = getRandomNature();
        WildPokemon wildPokemon = buildWildPokemon(pokemonService.getRandomPokemon(), level, individualValues, nature);

        return wildPokemon;
    }

    public WildPokemon getWildPokemon(Long id) {
        return wildPokemonRepository.findById(id).get();
    }

    private WildPokemon buildWildPokemon(Pokemon pokemon, Integer level, IndividualValues individualValues, Nature nature) {
        WildPokemon wildPokemon = new WildPokemon();
        wildPokemon.setPokemon(pokemon);
        wildPokemon.setLevel(level);
        wildPokemon.setIndividualValues(individualValues);
        wildPokemon.setNature(nature);
        calculatePokemonStats(wildPokemon);

        return wildPokemon;
    }
}
