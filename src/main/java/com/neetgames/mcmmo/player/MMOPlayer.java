package com.neetgames.mcmmo.player;

import com.neetgames.mcmmo.skill.Skill;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface MMOPlayer extends MMOPlayerDataContainer {
    @NotNull UUID getUUID();

    @NotNull String getPlayerName();

    int getPowerLevel();

    int getSkillLevel(@NotNull Skill skill);

    int getSkillExperience(@NotNull Skill skill);

    int getExperienceToNextLevel(@NotNull Skill skill);

    boolean isOnline();
}
