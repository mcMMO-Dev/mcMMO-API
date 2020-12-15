package com.neetgames.mcmmo.skill;

import org.jetbrains.annotations.NotNull;

public interface NamespacedSkill {
    /**
     * Get the {@link SkillIdentity} for this skill
     *
     * @return the {@link SkillIdentity} for this skill
     */
    @NotNull SkillIdentity getSkillIdentity();
}
