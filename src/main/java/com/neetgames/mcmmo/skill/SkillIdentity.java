package com.neetgames.mcmmo.skill;

import org.jetbrains.annotations.NotNull;

public interface SkillIdentity {
    /**
     * The fully qualified name for this skill
     * Will be in one of two formats
     *
     * For root skills - namespace.skillname all in lowercase
     * For other skills - namespace.parentskillname.skillname
     *
     * namespace will be the name of the plugin registering the skill, mcmmo is used for official skills
     *
     * @return the fully qualified name for this skill
     */
    @NotNull String getFullyQualifiedName();

    /**
     * Gets the namespace of this skill
     * Official skills use mcmmo as their namespace, other skills should use a unique identifier like their plugin name
     *
     * @return the namespace for this skill
     */
    @NotNull String getNamespace();

    /**
     * The name of this skill, this is before any localization
     *
     * @return the skill name without localization
     */
    @NotNull String getSkillName();
}
