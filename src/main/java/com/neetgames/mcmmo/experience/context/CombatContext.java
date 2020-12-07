package com.neetgames.mcmmo.experience.context;

import com.neetgames.jmal.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class CombatContext implements CombatExperienceContext {

    private final @NotNull LivingEntity livingEntity;

    public CombatContext(@NotNull LivingEntity livingEntity) {
        this.livingEntity = livingEntity;
    }

    /**
     * Get the {@link LivingEntity} involved in this experience context
     *
     * @return the {@link LivingEntity} involved in this experience context
     */
    @Override
    public @NotNull LivingEntity getLivingEntity() {
        return livingEntity;
    }
}
