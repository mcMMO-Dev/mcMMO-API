package com.neetgames.mcmmo.skill;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ChildSkill {
    /**
     * Get the parents of this Child Skill
     * @return the parents of this child skill
     */
    @NotNull List<RootSkill> getSkillHeritage();
}
