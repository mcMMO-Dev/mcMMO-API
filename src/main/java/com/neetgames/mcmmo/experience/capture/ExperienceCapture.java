package com.neetgames.mcmmo.experience.capture;

import com.neetgames.mcmmo.experience.context.ExperienceContext;
import com.neetgames.mcmmo.player.MMOPlayer;
import com.neetgames.mcmmo.skill.SkillIdentity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ExperienceCapture {

    /**
     * Get the skills involved in this experience capture
     *
     * @return the skills involved in this experience capture
     */
    @NotNull SkillIdentity[] getSkills();

    /**
     * Grab the {@link ExperienceContext} related to this experience capture
     * Null experience context is used for undefined contexts
     *
     * @return the {@link ExperienceContext} related to this capture, can be null
     */
    @Nullable ExperienceContext getExperienceContext();

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
