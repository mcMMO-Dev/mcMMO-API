package com.neetgames.mcmmo.api;

import com.neetgames.mcmmo.skill.Skill;
import org.jetbrains.annotations.NotNull;

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
     * Get the registered skills
     *
     * @return the registered skills
     */
    @NotNull Set<Skill> getRegisteredSkills();
}
