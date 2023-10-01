package com.foxobyte.pokenary.service;

import com.foxobyte.pokenary.dao.Game;
import com.foxobyte.pokenary.dao.Player;
import com.foxobyte.pokenary.dao.PlayerPokemon;
import com.foxobyte.pokenary.exception.GameDoesntExistException;
import com.foxobyte.pokenary.exception.GameHasStartedException;
import com.foxobyte.pokenary.repo.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    WildPokemonService wildPokemonService;
    @Autowired
    PlayerPokemonService playerPokemonService;
    private Random random = new Random();

    public Game createGame() {
        Game game = new Game();
        game.setWildPokemon(wildPokemonService.createWildPokemon(random.nextInt(100)));

        return gameRepository.save(game);
    }

    public Game joinGame(Long gameId, Long playerPokemonId) throws Exception {
        Optional<Game> optionalGame = gameRepository.findById(gameId);
        if (!optionalGame.isPresent()) throw new GameDoesntExistException("Game with Id: " + gameId + " does not exist");

        Game game = optionalGame.get();
        if (game.getHasStarted()) throw new GameHasStartedException("Game has started");

        game.addPlayer(playerPokemonService.getPlayerPokemon(playerPokemonId));
        gameRepository.save(game);

        return game;
    }

    public Game startGame(Long gameId) throws Exception {
        Optional<Game> optionalGame = gameRepository.findById(gameId);
        if (!optionalGame.isPresent()) throw new GameDoesntExistException("Game with Id: " + gameId + " does not exist");

        Game game = optionalGame.get();
        game.setHasStarted(true);
        gameRepository.save(game);

        return game;
    }
}
