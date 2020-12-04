package com.neetgames.mcmmo.experience;

public interface PartyExperienceGain extends com.neetgames.mcmmo.experience.ExperienceGain {

    /**
     * The original value of this experience gain
     * This is not equivalent to the amount of XP the players in party will get, but it was the value of the XP before it was distributed to party members
     * @return the original value of the experience gain
     */
    int originalValue();
}
