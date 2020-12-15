package com.neetgames.mcmmo.skill;

public interface RankedSkill extends Skill {
    int getNumRanks();

    int getRankUnlockRequirement();
}
