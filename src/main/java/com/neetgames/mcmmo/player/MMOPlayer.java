package com.neetgames.mcmmo.player;

import com.neetgames.mcmmo.skill.SkillIdentity;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface MMOPlayer extends MMOPlayerDataContainer {
    @NotNull UUID getUUID();

    @NotNull String getPlayerName();

    int getPowerLevel();

    int getSkillLevel(@NotNull SkillIdentity skillIdentity);

    int getSkillExperience(@NotNull SkillIdentity skillIdentity);

    int getExperienceToNextLevel(@NotNull SkillIdentity skillIdentity);

    boolean isOnline();
}
