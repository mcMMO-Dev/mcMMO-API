package com.neetgames.mcmmo.experience.context;

import com.neetgames.jmaw.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockExperienceContext implements ExperienceContext {

    @NotNull Block blockExperienceContext;

    public BlockExperienceContext(@NotNull Block block) {
        this.blockExperienceContext = block;
    }

    @Nullable
    @Override
    public Object getContext() {
        return blockExperienceContext;
    }

    /**
     * Get the {@link Block} involved in this experience context
     *
     * @return the {@link Block} involved in this experience context
     */
    public @NotNull Block getBlockExperienceContext() {
        return blockExperienceContext;
    }
}
