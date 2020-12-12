package com.neetgames.mcmmo.skill;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: This documentation is a rough draft and will be rewritten

/**
 * Used to identify skills
 * The goal of this class is to avoid namespace conflicts and clearly identify a skill with its established relationship to other skills as needed
 *
 * This class will include representation of the relationship between skills, which includes whether or not one skill is parented by another
 * Skills are not aware of their children, but they can be aware of their parents
 * You will be able to use the skill register to grab all children of a skill, but no SkillIdentity will be defined with children, the burden of the relationship declaration is on the children
 *
 * Any skill with a null parent skill within its SkillIdentity will be considered the skill at the top of the food chain, which at this point has been referred to as a PrimarySkill
 * Any skill with a parent will be considered a SubSkill and treated completely differently
 *
 * Skills with parents do not gain experience, and instead their intended effects will be based on the strength of the parent skill (its level)
 * Skills are registered, no two skills can share the same fully qualified name (in this case, a combination of the namespace and skill name)
 *
 * A fully qualified name is generated based on the namespace and skill name
 * @see #genFullyQualifiedName()
 */
public interface Skill {

    /**
     * Creates a fully qualified name for this skill
     * @return the fully qualified name for this skill
     */
    @NotNull String genFullyQualifiedName();

    /**
     * Whether or not this skill has a parent
     * @return true if this skill has a parent
     */
    default boolean isRootSkill() {
        return getParent() == null;
    }

    /**
     * Grab the parent of this skill if it exists
     * @return the parent for this skill, null if the skill does not have one
     */
    @Nullable Skill getParent();
}
