package com.neetgames.mcmmo.party;

import org.jetbrains.annotations.NotNull;

public interface PartyExperience {
    void setXpShareMode(@NotNull PartyExperienceShareMode partyExperienceShareMode);

    @NotNull PartyExperienceShareMode getXpShareMode();

    /**
     * Applies an experience gain
     *
     * @param xp Experience amount to add
     */
    void applyXpGain(float xp);

    int getLevel();

    void setLevel(int level);

    float getXp();

    void setXp(float xp);

    void addXp(float xp);

    //TODO: Why is it based on the number of party members? seems dumb
    int getXpToLevel();

    @NotNull String getXpToLevelPercentage();
}
