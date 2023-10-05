package com.foxobyte.pokenary.service;

import com.foxobyte.pokenary.dao.Game;
import com.foxobyte.pokenary.dao.Move;
import com.foxobyte.pokenary.dao.pokemon.PlayerPokemon;
import com.foxobyte.pokenary.dao.pokemon.WildPokemon;
import com.foxobyte.pokenary.exception.*;
import com.foxobyte.pokenary.repo.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import static com.foxobyte.pokenary.util.PokemonCalculator.calculatePokemonStats;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    WildPokemonService wildPokemonService;
    @Autowired
    PlayerPokemonService playerPokemonService;
    @Autowired
    MoveService moveService;
    private Random random = new Random();

    public Game createGame() {
        Game game = new Game();
        game.setWildPokemon(wildPokemonService.createWildPokemon(random.nextInt(100)));
//        calculatePokemonStats(game.getWildPokemon());

        return gameRepository.save(game);
    }

    public Game getGame(Long gameId) throws Exception {
        Optional<Game> optionalGame = gameRepository.findById(gameId);
        if (!optionalGame.isPresent()) throw new GameDoesntExistException("Game with Id: " + gameId + " does not exist");

        Game game = optionalGame.get();
        game.setWildPokemon((WildPokemon) calculatePokemonStats(game.getWildPokemon()));
        game.getPlayerPokemon().stream().map(pokemon -> (PlayerPokemon) calculatePokemonStats(pokemon)).collect(Collectors.toSet());

        return game;
    }

    public Game joinGame(Long gameId, Long playerId, Long playerPokemonId) throws Exception {
        Optional<Game> optionalGame = gameRepository.findById(gameId);
        if (!optionalGame.isPresent()) throw new GameDoesntExistException("Game with Id: " + gameId + " does not exist");

        Game game = optionalGame.get();
        if (game.getHasStarted()) throw new GameHasStartedException("Game has started");

        boolean isPokemonInGame = game.getPlayerPokemon().stream().anyMatch(playerPokemon -> playerPokemon.getId().equals(playerPokemonId));
        if (isPokemonInGame) throw new AlreadyInGameException("This pokemon is already in this game");
        PlayerPokemon playerPokemon = playerPokemonService.getPlayerPokemon(playerPokemonId);

        if (!playerPokemon.getPlayer().getId().equals(playerId)) throw new Exception("This is not your pokemon");
        boolean isPlayerInGame = game.getPlayerPokemon().stream().anyMatch(e -> e.getPlayer().getId().equals(playerId));
        if (isPlayerInGame) throw new AlreadyInGameException("This player already has a pokemon in this game");

        game.addPlayerPokemon(playerPokemon);
        gameRepository.save(game);

        return game;
    }

    public Game startGame(Long gameId) throws Exception {
        Optional<Game> optionalGame = gameRepository.findById(gameId);
        if (!optionalGame.isPresent()) throw new GameDoesntExistException("Game with Id: " + gameId + " does not exist");

        Game game = optionalGame.get();
        if (game.getHasStarted()) throw new GameHasStartedException("This game has already started");

        game.setHasStarted(true);
        gameRepository.save(game);

        return game;
    }

    public Game move(Long gameId, Long playerPokemonId, Integer moveId) throws Exception {
        Optional<Game> optionalGame = gameRepository.findById(gameId);
        if (optionalGame.isEmpty()) throw new GameDoesntExistException("Game with Id: " + gameId + " dos not exist");

        Game game = optionalGame.get();
        if (!game.getHasStarted()) throw new GameHasNotStartedException("Game with Id: " + gameId + " has not started");

        Optional<PlayerPokemon> optionalPlayerPokemon = game.getPlayerPokemon().stream().filter(e -> e.getId().equals(playerPokemonId)).findFirst();
        if (optionalPlayerPokemon.isEmpty()) throw new PokemonIsNotInGameException("This pokemon is not in this game");

        PlayerPokemon playerPokemon = optionalPlayerPokemon.get();
        Move move = moveService.getMove(moveId);
        move.getCategory().move(playerPokemon, game.getWildPokemon(), move);


        // Critical hit
        game.setMessage("THAT WAS A CRITICAL!! OMG!");

        // Fainting move ends game
        // add xp to pokemon
        // if pokemon levels up check moves learned by level

        return gameRepository.save(game);
    }
}
