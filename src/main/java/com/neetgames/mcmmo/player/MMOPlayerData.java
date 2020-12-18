package com.neetgames.mcmmo.player;

import com.google.common.collect.ImmutableMap;
import com.neetgames.mcmmo.UniqueDataType;
import com.neetgames.mcmmo.exceptions.ExpectedRootSkillException;
import com.neetgames.mcmmo.exceptions.UnknownSkillException;
import com.neetgames.mcmmo.skill.RootSkill;
import com.neetgames.mcmmo.skill.SkillBossBarState;
import com.neetgames.mcmmo.skill.SkillIdentity;
import com.neetgames.mcmmo.skill.SuperSkill;
import com.neetgames.neetlib.dirtydata.DirtyData;
import com.neetgames.neetlib.dirtydata.DirtyMap;
import com.neetgames.neetlib.mutableprimitives.MutableBoolean;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;

public interface MMOPlayerData {
    /**
     * Set the level of a {@link RootSkill}
     * Skills that aren't registered will throw errors, so check with the {@link com.neetgames.mcmmo.api.SkillRegister} implementation first
     *
     * @param skillIdentity the skill identity for the target skill
     * @param newSkillLevel the new value of the target skill
     * @throws UnknownSkillException if the skill identity does not match a registered root skill
     * @throws ExpectedRootSkillException when a skill is matched in the {@link com.neetgames.mcmmo.api.SkillRegister} but its not of type Root Skill
     *
     */
    @Deprecated
    void setSkillLevel(@NotNull SkillIdentity skillIdentity, int newSkillLevel) throws UnknownSkillException, ExpectedRootSkillException;

    /**
     * Set the level of a root skill for the Player
     * Skills that aren't registered will throw errors, so check with the {@link com.neetgames.mcmmo.api.SkillRegister} implementation first
     *
     * @param rootSkill target root skill
     * @param newSkillLevel the new value of the skill
     */
    void setSkillLevel(@NotNull RootSkill rootSkill, int newSkillLevel) throws UnknownSkillException;

    /**
     * Get the skill level the player currently has for target root skill
     * Skills that aren't registered will throw errors, so check with the {@link com.neetgames.mcmmo.api.SkillRegister} implementation first
     *
     * @param rootSkill target root skill
     * @return the current level value of target root skill
     */
    int getSkillLevel(@NotNull RootSkill rootSkill) throws UnknownSkillException;

    /**
     * True if the persistent data has changed state and not yet saved to DB
     * @return true if data is dirty (not saved)
     */
    boolean isDirtyProfile();

    /**
     * Set the dirty flag back to false
     * Should be called after saving the player data to avoid unnecessary saves
     */
    void resetDirtyFlag();

    /**
     * The saved player name for the player associated with this data
     * This will be the player name as it is saved in the mcMMO DB
     * The name in the mcMMO DB is updated when it is found to have changed, player nicknames in Minecraft are volatile so keep this in mind
     *
     * @return the saved player name for the player associated with this data
     */
    @NotNull String getPlayerName();

    /**
     * The {@link UUID} for the player associated with this data
     *
     * @return the UUID for the player associated with this data
     */
    @NotNull UUID getPlayerUUID();

    /*
     * Party Chat Spy
     */

    /**
     * Whether or not this player is currently spying on all party chat
     *
     * @return true if this player is spying on party chat
     */
    boolean isPartyChatSpying();

    /**
     * Toggle this player's party chat spying
     */
    void togglePartyChatSpying();

    /**
     * Modify whether or not this player is spying on party chat
     * @param bool the new value of party chat spying (true for spying, false for not spying)
     */
    void setPartyChatSpying(boolean bool);

    /*
     * Scoreboards
     */

    /**
     * The currently tracked number of times scoreboard tips have been viewed for this player
     * @return the currently tracked number of times scoreboard tips have been viewed for this player
     */
    int getScoreboardTipsShown();

    /**
     * Modify the count of how many times scoreboard tips have been displayed to this player
     * @param newValue the new value
     */
    void setScoreboardTipsShown(int newValue);

    /*
     * Cooldowns
     */

    /**
     * The time stamp for the last Chimaera Wing use for this player
     * @return the Chimaera Wing last use time stamp for this player
     */
    int getChimaeraWingDATS();

    /**
     * Set the time stamp for Chimaera Wing's last use for this player
     * @param DATS the new time stamp
     */
    void setChimaeraWingDATS(int DATS);

    /**
     * Change one of the unique data map entries
     * @param uniqueDataType target unique data
     * @param newData new unique data value
     */
    void setUniqueData(@NotNull UniqueDataType uniqueDataType, int newData);

    /**
     * Get the value associated with a specific {@link UniqueDataType}
     * @param uniqueDataType target unique data
     * @return associated value of this unique data
     */
    long getUniqueData(@NotNull UniqueDataType uniqueDataType);

    /**
     * Get the current deactivation timestamp of an superSkill.
     *
     * @param superSkill The {@link SuperSkill} to get the DATS for
     * @return the deactivation timestamp for the superSkill
     */
    long getAbilityDATS(@NotNull SuperSkill superSkill);

    /**
     * Set the current deactivation timestamp of an superSkill.
     *
     * @param superSkill The {@link SuperSkill} to set the DATS for
     * @param DATS the DATS of the superSkill
     */
    void setAbilityDATS(@NotNull SuperSkill superSkill, long DATS);

    /**
     * Reset all ability cooldowns.
     */
    void resetCooldowns();

    /**
     * Get the {@link Map} for the related {@link SkillBossBarState}'s of this player
     *
     * @return the bar state map for this player
     */
    @NotNull Map<RootSkill, SkillBossBarState> getBarStateMap();

    /**
     * Get the {@link DirtyMap} for the related {@link SkillBossBarState}'s of this player
     *
     * @return the dirty bar state map for this player
     */
    @NotNull DirtyMap<RootSkill, SkillBossBarState> getDirtyBarStateMap();

    /**
     * Get the {@link DirtyMap} for the skill levels of this player
     *
     * @return the dirty skill level map for this player
     */
    @NotNull DirtyMap<RootSkill, Integer> getDirtySkillLevelMap();

    /**
     * Get the {@link DirtyMap} for the skill experience values of this player
     *
     * @return the dirty skill experience values map for this player
     */
    @NotNull DirtyMap<RootSkill, Float> getDirtyExperienceValueMap();

    /**
     * Get the {@link DirtyData<MutableBoolean>} for the party chat toggle for this player
     *
     * @return the dirty data for the party chat toggle for this player
     */
    @NotNull DirtyData<MutableBoolean> getDirtyPartyChatSpying();

    /**
     * Get the skill level map for this player
     *
     * @return the map of skill levels for this player
     */
    @NotNull Map<RootSkill, Integer> getSkillLevelsMap();

    /**
     * Get the map of experience values for skills for this player
     *
     * @return the experience values map for this player
     */
    @NotNull Map<RootSkill, Float> getSkillsExperienceMap();

    /**
     * Get the map of timestamps representing the last use of abilities for this player
     *
     * @return the ability deactivation timestamps map for this player
     */
    @NotNull Map<SuperSkill, Integer> getAbilityDeactivationTimestamps();

    /**
     * Get a map of various unique data for this player
     *
     * @return a map of unique data for this player
     */
    @NotNull Map<UniqueDataType, Integer> getUniquePlayerData();

    /**
     * Mark this data as dirty which will flag this data for the next appropriate save
     *
     * Saves happen periodically, they also can happen on server shutdown and when the player disconnects from the server
     */
    void setDirtyProfile();

    /**
     * The timestamp of when this player last logged in
     *
     * @return the timestamp of when this player last logged in
     */
    long getLastLogin();

    /**
     * Set the value of when this player last logged in
     *
     * @param newValue the new time stamp
     */
    void setLastLogin(long newValue);

    /**
     * Whether or not this player is exempt from leader boards
     *
     * @return true if excluded from leader boards
     */
    boolean isLeaderBoardExcluded();

    /**
     * Set whether or not this player is excluded from leader boards
     *
     * @param bool new value
     */
    void setLeaderBoardExclusion(boolean bool);

    @NotNull ImmutableMap<RootSkill, Integer> copyPrimarySkillLevelsMap();

    @NotNull ImmutableMap<RootSkill, Float> copyPrimarySkillExperienceValuesMap();
}
