package com.foxobyte.pokenary.exception;

public class NotifiableException extends Exception {
    // integrate with Slack/Discord/Other Messaging Services
    public NotifiableException() {

    }

    public NotifiableException(String message) {
        super(message);
    }
}
