package com.neetgames.mcmmo.skill;

import com.neetgames.jmal.core.entity.Entity;
import com.neetgames.mcmmo.player.OnlineMMOPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface RootSkill extends Skill {
    default @Override @Nullable RootSkill getParent() {
        return null;
    }

    /**
     * Get the max level of this skill.
     *
     * @return the max level of this skill
     */
    default int getMaxLevel() { return Integer.MAX_VALUE; }

    /**
     * Whether or not this skill should apply offensively to PVP targets
     *
     * @return true if PVP is enabled for this skill
     */
    boolean isPVPPermitted();

    /**
     * Whether or not this skill should apply offensively to PVE targets
     *
     * @return true if PVE is enabled for this skill
     */
    boolean isPVEPermitted();

    /**
     * Whether or not this skill is affected by hardcore mode stat loss penalties
     *
     * @return true if hardcore stat loss penalties apply to this skill
     */
    boolean isAffectedByHardcoreModeStatLoss();

    /**
     * Whether or not this skill is affected by hardcore mode vampirism interaction
     *
     * @return whether or not this skill is affected by the hardcore mode vampirism interaction
     */
    boolean getHardcoreVampirismEnabled();

    /**
     * Whether or not a {@link OnlineMMOPlayer} has permission to use a skill
     * The player must have the appropriate permission for the skill if any exists
     *
     * @param mmoPlayer target player
     * @return true if the skill is permitted
     */
    boolean isRootSkillPermitted(@NotNull OnlineMMOPlayer mmoPlayer);

    /**
     * The experience modifier for this skill, for core skills this will reflect the value defined in the config
     * The default value is 1.0
     *
     * @return the experience modifier for this skill, multiplied against the experience gain during experience value modifier application
     */
    default double getExperienceFormulaMultiplier() { return 1.0D; }

    /**
     * Whether or not an offensive action is allowed against a target {@link Entity}
     * Basically this checks if the target is a PVE or PVP target, then checks whether or not an offensive action is allowed against said target via checking server settings
     *
     * @param targetEntity the target entity
     * @return true if the action is allowed
     */
    boolean isOffensiveActionAllowed(@NotNull Object targetEntity);
}

