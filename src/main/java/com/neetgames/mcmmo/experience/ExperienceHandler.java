package com.neetgames.mcmmo.experience;

import com.neetgames.mcmmo.exceptions.UnknownSkillException;
import com.neetgames.mcmmo.skill.RootSkill;
import org.jetbrains.annotations.NotNull;

public interface ExperienceHandler {
    int getSkillLevel(@NotNull RootSkill rootSkill);

    /**
     * Gets the power level of this player.
     * A power level is the sum of all skill levels for this player
     *
     * @return the power level of the player
     */
    int getPowerLevel();

    /**
     * Get the current value of raw XP for a skill
     *
     * @param rootSkill target skill
     * @return the value of raw XP for target skill
     */
    float getSkillXpLevelRaw(@NotNull RootSkill rootSkill);

    /**
     * Get the value of XP a player has accumulated in target skill
     * Child Skills will return 0 (Child Skills will be removed in a future update)
     * @param rootSkill target skill
     * @return the value for XP the player has accumulated in target skill
     */
    int getSkillXpValue(@NotNull RootSkill rootSkill);

    void setSkillXpValue(@NotNull RootSkill rootSkill, float xpLevel);

    float levelUp(@NotNull RootSkill rootSkill);

    /**
     * Whether or not a player is level capped in a specific skill (also checks the power level cap)
     * If they are at the power level cap, this will return true, otherwise it checks their skill level
     *
     * @param rootSkill target root skill
     * @return true if the player has reached either the power level cap or the level cap for the specified skill
     */
    boolean hasReachedLevelCap(@NotNull RootSkill rootSkill);

    /**
     * Whether or not a player is power level capped
     * Compares their power level total to the current set limit
     * @return true if they have reached the power level cap
     */
    boolean hasReachedPowerLevelCap();

    /**
     * Begins an experience gain. The amount will be affected by skill modifiers, global rate, perks, and may be shared with the party
     *
     * @param rootSkill Skill being used
     * @param xp Experience amount to process
     */
    void beginXpGain(@NotNull RootSkill rootSkill, float xp, @NotNull XPGainReason xpGainReason, @NotNull XPGainSource xpGainSource);

    /**
     * Begins an experience gain. The amount will be affected by skill modifiers, global rate and perks
     *
     * @param rootSkill Skill being used
     * @param xp Experience amount to process
     */
    void beginUnsharedXpGain(@NotNull RootSkill rootSkill, float xp, @NotNull XPGainReason xpGainReason, @NotNull XPGainSource xpGainSource);

    /**
     * Get the amount of Xp remaining before the next level.
     *
     * @param rootSkill Type of skill to check
     * @return the total amount of Xp until next level
     */
    int getExperienceToNextLevel(@NotNull RootSkill rootSkill);

    @Deprecated
    int getChildSkillLevel(@NotNull RootSkill rootSkill);

    /*
     * Xp Functions
     */

    /**
     * Remove Xp from a skill.
     *
     * @param rootSkill Type of skill to modify
     * @param xp Amount of xp to remove
     */
    void removeXp(@NotNull RootSkill rootSkill, int xp);

    void removeXp(RootSkill rootSkill, float xp);

    /**
     * Modify a rootSkill level.
     *
     * @param rootSkill Type of rootSkill to modify
     * @param level New level value for the rootSkill
     */
    void setSkillLevel(@NotNull RootSkill rootSkill, int level);

    /**
     * Add levels to a rootSkill.
     *
     * @param rootSkill Type of rootSkill to add levels to
     * @param levels Number of levels to add
     */
    void addLevels(@NotNull RootSkill rootSkill, int levels);

    /**
     * Add Experience to a rootSkill.
     *
     * @param rootSkill Type of rootSkill to add experience to
     * @param xp Number of experience to add
     */
    void addXp(@NotNull RootSkill rootSkill, float xp);

    /**
     * Get the registered amount of experience gained
     * This is used for diminished XP returns
     *
     * @return xp Experience amount registered
     */
    float getRegisteredXpGain(@NotNull RootSkill rootSkill);

    /**
     * Register an experience gain
     * This is used for diminished XP returns
     *
     * @param rootSkill rootSkill being used
     * @param xp Experience amount to add
     */
    void registerXpGain(@NotNull RootSkill rootSkill, float xp);

    /**
     * Remove experience gains older than a given time
     * This is used for diminished XP returns
     */
    void purgeExpiredXpGains();

    /**
     * Modifies an experience gain using skill modifiers, global rate and perks
     *
     * @param rootSkill Skill being used
     * @param xp Experience amount to process
     * @return Modified experience
     */
    float applyExperienceModifiers(@NotNull RootSkill rootSkill, float xp);

    double getProgressInCurrentSkillLevel(@NotNull RootSkill rootSkill) throws UnknownSkillException;

    /**
     * Applies an experience gain
     *
     * @param rootSkill rootSkill being used
     * @param xp Experience amount to add
     */
    void applyXpGain(@NotNull RootSkill rootSkill, float xp, @NotNull XPGainReason xpGainReason, @NotNull XPGainSource xpGainSource);

    void processPostXpEvent(@NotNull RootSkill rootSkill, @NotNull XPGainSource xpGainSource);

    /**
     * Updates a players level
     *
     * @param rootSkill The skill to check
     */
    void updateLevelStats(@NotNull RootSkill rootSkill, @NotNull XPGainReason xpGainReason, @NotNull XPGainSource xpGainSource);
}
