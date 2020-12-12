package com.neetgames.mcmmo.player;

import org.jetbrains.annotations.NotNull;

public interface MMOPlayerDataContainer {
    /**
     * Grab the {@link MMOPlayerData}
     *
     * @return the {@link MMOPlayerData}
     */
    @NotNull MMOPlayerData getMMOPlayerData();
}
