package com.neetgames.mcmmo.experience.capture;

import com.neetgames.mcmmo.player.MMOPlayer;
import com.neetgames.mcmmo.skill.SkillIdentity;
import org.jetbrains.annotations.NotNull;

public interface ExperienceSnapshot {
    /**
     * Check whether or not a skill is targeted in this experience capture
     *
     * @param skillIdentity target skill
     * @return true if this skill is targeted in this experience capture
     */
    boolean isSkillAffected(@NotNull SkillIdentity skillIdentity);

    /**
     * Check whether or not a skill is targeted in this experience capture
     *
     * @param fullyQualifiedSkillIdentity the fully qualified skill identity
     * @return true if this skill is targeted in this experience capture
     */
    boolean isSkillAffected(@NotNull String fullyQualifiedSkillIdentity);

    /**
     * Get the related players for this experience snapshot
     *
     * @return the players involved in this experience snapshot
     */
    @NotNull MMOPlayer[] getPlayers();
}
