package com.neetgames.mcmmo.player;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface MMOPlayer {
    @NotNull UUID getUUID();

    @NotNull String getPlayerName();

    int getPowerLevel();

    boolean isOnline();
}
