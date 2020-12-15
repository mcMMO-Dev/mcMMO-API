package com.neetgames.mcmmo.skill;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public interface Skill extends Permissive, NamespacedSkill {
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

    /**
     * The skill name, this is not localized and English should be expected
     *
     * @return the unlocalized skill name
     */
    @NotNull String getSkillName();

    /**
     * Whether or not this skill has a parent
     *
     * @return whether or not this skill has a parent
     */
    default boolean hasParent() { return getParent() != null; }

    /**
     * Whether or not the provided {@link SkillIdentity} is the parent of this {@link Skill}
     *
     * @param skillIdentity target skill identity
     * @return true if the skill identity is the parent, false if the skill does not have a parent or it is not a match
     */
    boolean isChildOf(@NotNull SkillIdentity skillIdentity);

    /**
     * Whether or not the provided {@link RootSkill} is the parent of this {@link Skill}
     *
     * @param rootSkill target root skill
     * @return true if the skill identity is the parent, false if the skill does not have a parent or it is not a match
     */
    boolean isChildOf(@NotNull RootSkill rootSkill);
}
