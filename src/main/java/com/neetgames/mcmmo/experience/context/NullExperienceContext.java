package com.neetgames.mcmmo.experience.context;

import org.jetbrains.annotations.Nullable;

/**
 * Represents an experience context with an undefined source
 */
public class NullExperienceContext implements ExperienceContext {
    @Override
    public @Nullable Object getContext() {
        return null;
    }
}
