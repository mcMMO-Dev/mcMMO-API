package com.neetgames.mcmmo.experience.context;

import com.neetgames.jmal.core.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public interface CombatExperienceContext extends ExperienceContext {

    /**
     * Get the {@link LivingEntity} involved in this experience context
     *
     * @return the {@link LivingEntity} involved in this experience context
     */
    @NotNull LivingEntity getLivingEntity();
}
