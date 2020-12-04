package com.neetgames.mcmmo.exceptions;

import org.jetbrains.annotations.NotNull;

public class IncompleteNamespacedKeyRegister extends RuntimeException {
    private static final long serialVersionUID = -6905157273569301219L;

    public IncompleteNamespacedKeyRegister(@NotNull String message) {
        super(message);
    }
}
