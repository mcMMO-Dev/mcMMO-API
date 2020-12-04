package com.neetgames.mcmmo.exceptions;

public class InvalidXPGainReasonException extends RuntimeException {
    private static final long serialVersionUID = 4427052841957931157L;

    public InvalidXPGainReasonException() {
        super("That is not a valid XPGainReason.");
    }
}
