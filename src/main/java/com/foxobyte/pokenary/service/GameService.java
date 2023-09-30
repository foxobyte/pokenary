package com.foxobyte.pokenary.service;

import com.foxobyte.pokenary.dao.Game;
import com.foxobyte.pokenary.dao.Player;
import com.foxobyte.pokenary.exception.GameHasStartedException;
import com.foxobyte.pokenary.repo.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    PokemonService pokemonService;

    public Game createGame() {
        Game game = new Game();
        game.setWildPokemon(pokemonService.getRandomPokemon());

        return gameRepository.save(game);
    }

    public Game joinGame(Game game, Player player) throws GameHasStartedException {
        if (game.getHasStarted()) throw new GameHasStartedException("Game has started");
//        game.addPlayer(player);
        gameRepository.save(game);

        return game;
    }

    public Game startGame(Game game) {
        game.setHasStarted(true);
        return game;
    }
}
