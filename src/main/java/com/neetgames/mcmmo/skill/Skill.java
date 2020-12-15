package com.neetgames.mcmmo.skill;

import org.jetbrains.annotations.Nullable;


public interface Skill extends Permissive, SkillIdentity {
    /**
     * Whether or not this skill is a {@link RootSkill}
     * {@link RootSkill} are the skills at the very top of the hierarchy, they are always parentless
     *
     * @return true if this skill is a {@link RootSkill}
     */
    default boolean isRootSkill() {
        return this instanceof RootSkill;
    }

    /**
     * Grab the parent of this skill if it exists
     * @return the parent for this skill, null if the skill does not have one
     */
    @Nullable Skill getParent();
}
