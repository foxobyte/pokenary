package com.foxobyte.pokenary.service;

import com.foxobyte.pokenary.dao.*;
import com.foxobyte.pokenary.dao.pokemon.PlayerPokemon;
import com.foxobyte.pokenary.dao.pokemon.Pokemon;
import com.foxobyte.pokenary.dao.pokemon.WildPokemon;
import com.foxobyte.pokenary.repo.IndividualValuesRepository;
import com.foxobyte.pokenary.repo.PlayerPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.foxobyte.pokenary.util.PokemonCalculator.calculatePokemonStats;

@Service
public class PlayerPokemonService {
    @Autowired
    PlayerService playerService;
    @Autowired
    WildPokemonService wildPokemonService;
//    @Autowired
//    PokemonService pokemonService;
//    @Autowired
//    MoveService moveService;
    @Autowired
    PlayerPokemonRepository playerPokemonRepository;
    @Autowired
    IndividualValuesRepository individualValuesRepository;

    public PlayerPokemon createPlayerPokemon(Long playerId, Long wildPokemonId) throws Exception {
        Player player = playerService.getPlayer(playerId);
        WildPokemon wildPokemon = wildPokemonService.getWildPokemon(wildPokemonId);
        PlayerPokemon playerPokemon = buildPlayerPokemon(player, wildPokemon);

        return playerPokemon;
    }

    public PlayerPokemon createPlayerPokemon(PlayerPokemon playerPokemon) {
        individualValuesRepository.save(playerPokemon.getIndividualValues());
        calculatePokemonStats(playerPokemon);
        return playerPokemonRepository.save(playerPokemon);
    }

    public PlayerPokemon getPlayerPokemon(Long playerPokemonId) {
        PlayerPokemon playerPokemon = playerPokemonRepository.findById(playerPokemonId).get();

        return playerPokemon;
    }

//    public PlayerPokemon chooseStarterPokemon(Long playerId, Integer pokemonId) throws Exception {
//        Player player = playerService.getPlayer(playerId);
//        Pokemon pokemon = pokemonService.getStarterPokemon(pokemonId);
//        PlayerPokemon playerPokemon = buildPlayerPokemon(player, pokemon);
//
//        return playerPokemon;
//    }

    public PlayerPokemon updatePlayerPokemon(PlayerPokemon playerPokemon) {
        return playerPokemonRepository.save(playerPokemon);
    }

    public PlayerPokemon learnMove(Long playerPokemonId, Integer moveId) {
        PlayerPokemon playerPokemon = playerPokemonRepository.findById(playerPokemonId).get();
//        Move move = moveService.getMove(moveId);
//        playerPokemon.addMove(move);
        return playerPokemonRepository.save(playerPokemon);
    }

    private PlayerPokemon buildPlayerPokemon(Player player, Pokemon pokemon) {
        PlayerPokemon playerPokemon = new PlayerPokemon();
        playerPokemon.setPlayer(player);
        playerPokemon.setPokemon(pokemon);
        playerPokemon.setLevel(5);

        return playerPokemon;
    }

    private PlayerPokemon buildPlayerPokemon(Player player, WildPokemon wildPokemon) {
        PlayerPokemon playerPokemon = new PlayerPokemon();
        playerPokemon.setPokemon(wildPokemon.getPokemon());
        playerPokemon.setLevel(wildPokemon.getLevel());
        playerPokemon.setPlayer(player);
        calculatePokemonStats(playerPokemon);

        return playerPokemon;
    }
}
