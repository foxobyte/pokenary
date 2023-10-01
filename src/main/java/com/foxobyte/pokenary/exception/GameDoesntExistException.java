package com.foxobyte.pokenary.exception;

public class GameDoesntExistException extends Exception {
    public GameDoesntExistException(String message) {
        super(message);
    }
}
