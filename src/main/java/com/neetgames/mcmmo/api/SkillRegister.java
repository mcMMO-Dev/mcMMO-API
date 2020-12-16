package com.neetgames.mcmmo.api;

import com.neetgames.mcmmo.skill.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public interface SkillRegister {
    /**
     * Whether or not a skill has been registered with mcMMO yet
     * @param skill target skill
     *
     * @return true if the skill has been registered
     */
    boolean isSkillRegistered(@NotNull Skill skill);

    void registerSkill(@NotNull Skill skill);

    /**
     * Registers a skill
     * If the skill already exists then it will be replaced if override is set to true
     *
     * @param skill target skill
     * @param override whether or not to replace a skill that was already registered
     */
    @Deprecated
    void registerSkill(@NotNull Skill skill, boolean override);

    /**
     * Get the registered skills
     *
     * @return the registered skills
     */
    @NotNull Set<Skill> getRegisteredSkills();

    /**
     * Removes a skill from the register
     * This just removes mcMMO's awareness of the skill
     *
     * @param skill skill to unregister
     */
    @Deprecated
    void unregisterSkill(@NotNull Skill skill);

    /**
     * Gets a skill by its fully qualified name
     *
     * @param fullyQualifiedName the fully qualified name of a skill
     * @return the skill with the same fully qualified name, null if the skill is not found in the register
     */
    @Nullable Skill getSkill(@NotNull String fullyQualifiedName);

    /**
     * Gets a skill by its fully qualified name
     *
     * @param skillIdentity the skill identity of a skill
     * @return the skill with the same fully qualified name, null if the skill is not found in the register
     */
    @Nullable Skill getSkill(@NotNull SkillIdentity skillIdentity);

    /**
     * Get all registered skills which are of type {@link SuperSkill}
     *
     * @return all registered {@link SuperSkill}, the returned set can be empty but never null
     */
    @NotNull Set<SuperSkill> getSuperSkills();

    /**
     * Get all registered skills which are of type {@link RankedSkill}
     *
     * @return all registered {@link RankedSkill}, the returned set can be empty but never null
     */
    @NotNull Set<RankedSkill> getRankedSkills();

    /**
     * Get all registered skills which are of type {@link RootSkill}
     *
     * @return all registered {@link RootSkill}, the returned set can be empty but never null
     */
    @NotNull Set<RootSkill> getRootSkills();

    /**
     * Get all registered skills which are of type {@link RootSkill} and are official skills
     *
     * @return all registered core {@link RootSkill}s, the returned set can be empty but never null
     */
    @NotNull Set<RootSkill> getCoreRootSkills();
}
