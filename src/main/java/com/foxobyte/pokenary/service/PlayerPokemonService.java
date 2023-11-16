package com.foxobyte.pokenary.service;

import com.foxobyte.pokenary.constants.Generation;
import com.foxobyte.pokenary.dao.*;
import com.foxobyte.pokenary.dao.pokemon.*;
import com.foxobyte.pokenary.repo.DeterminantValuesRepository;
import com.foxobyte.pokenary.repo.IndividualValuesRepository;
import com.foxobyte.pokenary.repo.PlayerPokemonRepository;
import com.foxobyte.pokenary.repo.StatsExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.foxobyte.pokenary.util.RNGCalculator.generateDeterminantValues;
import static com.foxobyte.pokenary.util.RNGCalculator.generateIndividualValues;

@Service
public class PlayerPokemonService {
    @Autowired
    PlayerService playerService;
    @Autowired
    WildPokemonService wildPokemonService;
    @Autowired
    IndividualValuesRepository individualValuesRepository;
    @Autowired
    DeterminantValuesRepository determinantValuesRepository;
    @Autowired
    StatsExperienceRepository statsExperienceRepository;
//    @Autowired
//    PokemonService pokemonService;
//    @Autowired
//    MoveService moveService;
    @Autowired
    PlayerPokemonRepository playerPokemonRepository;

    public PlayerPokemon createPlayerPokemon(Long playerId, Long wildPokemonId) throws Exception {
        Player player = playerService.getPlayer(playerId);
        WildPokemon wildPokemon = wildPokemonService.getWildPokemon(wildPokemonId);
        PlayerPokemon playerPokemon = buildPlayerPokemon(player, wildPokemon);

        return playerPokemon;
    }

    public PlayerPokemon createPlayerPokemon(Generation generation, PlayerPokemon playerPokemon) {
        if (generation.getGeneration() < 3) {
            // ToDo: Implement personality values
            DeterminantValues determinantValues = determinantValuesRepository.save(generateDeterminantValues());
            playerPokemon.setDeterminantValues(determinantValues);
            StatsExperience statsExperience = statsExperienceRepository.save(new StatsExperience(0L, 0, 0, 0, 0, 0, 0));
            playerPokemon.setStatsExperience(statsExperience);
        } else {
            IndividualValues individualValues = individualValuesRepository.save(generateIndividualValues());
            playerPokemon.setIndividualValues(individualValues);
            playerPokemon.setEffortValues(new EffortValues(0L, 0, 0, 0, 0, 0, 0));
        }

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
//        calculatePokemonStats(playerPokemon);

        return playerPokemon;
    }
}
