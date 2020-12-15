package com.neetgames.mcmmo.skill;

import com.neetgames.mcmmo.exceptions.InvalidSkillRankException;

public interface RankedSkill extends Skill {
    /**
     * The number of ranks that this skill has
     *
     * @return the number of ranks this skill has
     */
    int getNumRanks();

    /**
     * Get the rank unlock requirement for a skill
     * @param rankLevel the rank level
     * @return the level required to have unlocked the targeted rank of this skill
     *
     * @throws InvalidSkillRankException if an invalid rank is requested, always check the number of ranks with {@link #getNumRanks()}
     */
    int getRankUnlockRequirement(int rankLevel) throws InvalidSkillRankException;
}
