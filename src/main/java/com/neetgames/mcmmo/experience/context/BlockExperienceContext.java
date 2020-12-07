package com.neetgames.mcmmo.experience.context;

import com.neetgames.jmal.Block;
import org.jetbrains.annotations.NotNull;

public interface BlockExperienceContext extends ExperienceContext {

    /**
     * Get the Block involved in this experience context
     *
     * @return the {@link Block} involved in this experience context
     */
    @NotNull Block getBlockExperienceContext();

}
