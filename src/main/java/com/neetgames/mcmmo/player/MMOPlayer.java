package com.neetgames.mcmmo.player;

import com.neetgames.mcmmo.exceptions.UnknownSkillException;
import com.neetgames.mcmmo.skill.SkillIdentity;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface MMOPlayer extends MMOPlayerDataContainer {
    @NotNull UUID getUUID();

    @NotNull String getPlayerName();

    int getPowerLevel();

    int getSkillLevel(@NotNull SkillIdentity skillIdentity) throws UnknownSkillException;

    int getSkillExperience(@NotNull SkillIdentity skillIdentity) throws UnknownSkillException;

    int getExperienceToNextLevel(@NotNull SkillIdentity skillIdentity) throws UnknownSkillException;

    double getProgressInCurrentSkillLevel(@NotNull SkillIdentity skillIdentity) throws UnknownSkillException;

    boolean isOnline();
}
