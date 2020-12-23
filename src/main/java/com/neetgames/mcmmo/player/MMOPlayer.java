package com.neetgames.mcmmo.player;

import com.neetgames.mcmmo.exceptions.UnknownSkillException;
import com.neetgames.mcmmo.experience.ExperienceContainer;
import com.neetgames.mcmmo.skill.RootSkill;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface MMOPlayer extends MMOPlayerDataContainer, ExperienceContainer {
    @NotNull UUID getUUID();

    @NotNull String getPlayerName();

    int getPowerLevel();

    int getSkillLevel(@NotNull RootSkill rootSkill) throws UnknownSkillException;

    int getSkillExperience(@NotNull RootSkill rootSkill) throws UnknownSkillException;

    int getExperienceToNextLevel(@NotNull RootSkill rootSkill) throws UnknownSkillException;

    double getProgressInCurrentSkillLevel(@NotNull RootSkill rootSkill) throws UnknownSkillException;

    boolean isOnline();
}
