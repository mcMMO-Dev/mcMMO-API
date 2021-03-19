package com.neetgames.mcmmo.experience;

import com.neetgames.mcmmo.exceptions.UnknownSkillException;
import com.neetgames.mcmmo.skill.CorePrimarySkillType;
import org.jetbrains.annotations.NotNull;

//TODO: T&C rewrite javadocs
public interface ExperienceProcessor {
    int getSkillLevel(@NotNull CorePrimarySkillType corePrimarySkillType);

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
     * @param corePrimarySkillType target skill
     * @return the value of raw XP for target skill
     */
    float getSkillXpLevelRaw(@NotNull CorePrimarySkillType corePrimarySkillType);

    /**
     * Get the value of XP a player has accumulated in target skill
     * Child Skills will return 0 (Child Skills will be removed in a future update)
     * @param corePrimarySkillType target skill
     * @return the value for XP the player has accumulated in target skill
     */
    int getSkillXpValue(@NotNull CorePrimarySkillType corePrimarySkillType);

    void setSkillXpValue(@NotNull CorePrimarySkillType corePrimarySkillType, float xpLevel);

    float levelUp(@NotNull CorePrimarySkillType corePrimarySkillType);

    /**
     * Whether or not a player is level capped in a specific skill (also checks the power level cap)
     * If they are at the power level cap, this will return true, otherwise it checks their skill level
     *
     * @param corePrimarySkillType target core skill
     * @return true if the player has reached either the power level cap or the level cap for the specified skill
     */
    boolean hasReachedLevelCap(@NotNull CorePrimarySkillType corePrimarySkillType);

    /**
     * Whether or not a player is power level capped
     * Compares their power level total to the current set limit
     * @return true if they have reached the power level cap
     */
    boolean hasReachedPowerLevelCap();

    /**
     * Begins an experience gain. The amount will be affected by skill modifiers, global rate, perks, and may be shared with the party
     *
     * @param corePrimarySkillType Skill being used
     * @param xp Experience amount to process
     */
    void beginXpGain(@NotNull CorePrimarySkillType corePrimarySkillType, float xp, @NotNull XPGainReason xpGainReason, @NotNull XPGainSource xpGainSource);

    /**
     * Begins an experience gain. The amount will be affected by skill modifiers, global rate and perks
     *
     * @param corePrimarySkillType Skill being used
     * @param xp Experience amount to process
     */
    void beginUnsharedXpGain(@NotNull CorePrimarySkillType corePrimarySkillType, float xp, @NotNull XPGainReason xpGainReason, @NotNull XPGainSource xpGainSource);

    /**
     * Get the amount of Xp remaining before the next level.
     *
     * @param corePrimarySkillType Type of skill to check
     * @return the total amount of Xp until next level
     */
    int getExperienceToNextLevel(@NotNull CorePrimarySkillType corePrimarySkillType);

    @Deprecated
    int getChildSkillLevel(@NotNull CorePrimarySkillType corePrimarySkillType);

    /*
     * Xp Functions
     */

    /**
     * Remove Xp from a skill.
     *
     * @param corePrimarySkillType Type of skill to modify
     * @param xp Amount of xp to remove
     */
    void removeXp(@NotNull CorePrimarySkillType corePrimarySkillType, int xp);

    void removeXp(CorePrimarySkillType corePrimarySkillType, float xp);

    /**
     * Modify a corePrimarySkillType level.
     *
     * @param corePrimarySkillType Type of corePrimarySkillType to modify
     * @param level New level value for the corePrimarySkillType
     */
    void setSkillLevel(@NotNull CorePrimarySkillType corePrimarySkillType, int level);

    /**
     * Add levels to a corePrimarySkillType.
     *
     * @param corePrimarySkillType Type of corePrimarySkillType to add levels to
     * @param levels Number of levels to add
     */
    void addLevels(@NotNull CorePrimarySkillType corePrimarySkillType, int levels);

    /**
     * Add Experience to a corePrimarySkillType.
     *
     * @param corePrimarySkillType Type of corePrimarySkillType to add experience to
     * @param xp Number of experience to add
     */
    void addXp(@NotNull CorePrimarySkillType corePrimarySkillType, float xp);

    /**
     * Get the registered amount of experience gained
     * This is used for diminished XP returns
     *
     * @return xp Experience amount registered
     */
    float getRegisteredXpGain(@NotNull CorePrimarySkillType corePrimarySkillType);

    /**
     * Register an experience gain
     * This is used for diminished XP returns
     *
     * @param corePrimarySkillType corePrimarySkillType being used
     * @param xp Experience amount to add
     */
    void registerXpGain(@NotNull CorePrimarySkillType corePrimarySkillType, float xp);

    /**
     * Remove experience gains older than a given time
     * This is used for diminished XP returns
     */
    void purgeExpiredXpGains();

    /**
     * Modifies an experience gain using skill modifiers, global rate and perks
     *
     * @param corePrimarySkillType Skill being used
     * @param xp Experience amount to process
     * @return Modified experience
     */
    float applyExperienceModifiers(@NotNull CorePrimarySkillType corePrimarySkillType, float xp);

    double getProgressInCurrentSkillLevel(@NotNull CorePrimarySkillType corePrimarySkillType) throws UnknownSkillException;

    /**
     * Applies an experience gain
     *
     * @param corePrimarySkillType corePrimarySkillType being used
     * @param xp Experience amount to add
     */
    void applyXpGain(@NotNull CorePrimarySkillType corePrimarySkillType, float xp, @NotNull XPGainReason xpGainReason, @NotNull XPGainSource xpGainSource);

    void processPostXpEvent(@NotNull CorePrimarySkillType corePrimarySkillType, @NotNull XPGainSource xpGainSource);

    /**
     * Updates a players level
     *
     * @param corePrimarySkillType The skill to check
     */
    void updateLevelStats(@NotNull CorePrimarySkillType corePrimarySkillType, @NotNull XPGainReason xpGainReason, @NotNull XPGainSource xpGainSource);
}
