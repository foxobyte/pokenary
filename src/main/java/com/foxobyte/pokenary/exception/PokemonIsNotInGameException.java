package com.foxobyte.pokenary.exception;

public class PokemonIsNotInGameException extends Exception {
    public PokemonIsNotInGameException(String message) {
        super(message);
    }
}
