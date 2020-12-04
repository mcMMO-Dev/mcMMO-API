package com.neetgames.mcmmo.experience.context;

import com.neetgames.jmaw.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CombatContext implements ExperienceContext {

    private final @NotNull LivingEntity livingEntity;

    public CombatContext(@NotNull LivingEntity livingEntity) {
        this.livingEntity = livingEntity;
    }

    @Nullable
    @Override
    public Object getContext() {
        return livingEntity;
    }

    /**
     * Get the {@link LivingEntity} involved in this experience context
     *
     * @return the {@link LivingEntity} involved in this experience context
     */
    public @NotNull LivingEntity getLivingEntity() {
        return livingEntity;
    }
}
