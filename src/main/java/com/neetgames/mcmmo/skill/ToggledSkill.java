package com.neetgames.mcmmo.skill;

/**
 * Skills which can be turned on or off
 */
public interface ToggledSkill {
    boolean isEnabled();

    boolean isDisabled();

    void enableSkill();

    void disableSkill();
}
