package com.neetgames.mcmmo.player;

import com.neetgames.mcmmo.experience.ExperienceProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface MMOPlayer {
    @NotNull UUID getUUID();

    @NotNull String getPlayerName();

    int getPowerLevel();

    boolean isOnline();

    @Nullable ExperienceProcessor getExperienceProcessor();
}
