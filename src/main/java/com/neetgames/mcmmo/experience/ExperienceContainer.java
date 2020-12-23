package com.neetgames.mcmmo.experience;

import org.jetbrains.annotations.NotNull;

public interface ExperienceContainer {

    /**
     * Get the experience handler
     *
     * @return the experience handler
     */
    @NotNull ExperienceHandler getExperienceHandler();
}
