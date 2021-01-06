package com.neetgames.mcmmo.player;

import org.jetbrains.annotations.NotNull;

public interface SuperSkilled {
    /**
     * Grab the {@link SuperSkillManager} for this
     *
     * @return the super skill manager
     */
    @NotNull SuperSkillManager getSuperSkillManager();
}
