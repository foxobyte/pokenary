package com.foxobyte.pokenary.service;

import com.foxobyte.pokenary.dao.Player;
import com.foxobyte.pokenary.dao.PlayerPokemon;
import com.foxobyte.pokenary.dao.Pokemon;
import com.foxobyte.pokenary.dao.WildPokemon;
import com.foxobyte.pokenary.repo.PlayerPokemonRepository;
import com.foxobyte.pokenary.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerPokemonService {
    @Autowired
    PlayerService playerService;
    @Autowired
    WildPokemonService wildPokemonService;
    @Autowired
    PokemonService pokemonService;
    @Autowired
    PlayerPokemonRepository playerPokemonRepository;

    public PlayerPokemon createPlayerPokemon(Long playerId, Integer wildPokemonId) throws Exception {
        Player player = playerService.getPlayer(playerId);
        WildPokemon wildPokemon = wildPokemonService.getWildPokemon(wildPokemonId);
        PlayerPokemon playerPokemon = buildPlayerPokemon(player, wildPokemon);

        return playerPokemon;
    }

    public PlayerPokemon getPlayerPokemon(Long playerPokemonId) {
        PlayerPokemon playerPokemon = playerPokemonRepository.findById(playerPokemonId).get();

        return playerPokemon;
    }

    public PlayerPokemon chooseStarterPokemon(Long playerId, Integer pokemonId) throws Exception {
        Player player = playerService.getPlayer(playerId);
        Pokemon pokemon = pokemonService.getStarterPokemon(pokemonId);
        PlayerPokemon playerPokemon = buildPlayerPokemon(player, pokemon);

        return playerPokemon;
    }

    public PlayerPokemon updatePlayerPokemon(PlayerPokemon playerPokemon) {
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

        return playerPokemon;
    }
}
