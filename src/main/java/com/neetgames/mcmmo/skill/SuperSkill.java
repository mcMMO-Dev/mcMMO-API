package com.neetgames.mcmmo.skill;

import com.neetgames.mcmmo.player.OnlineMMOPlayer;
import org.jetbrains.annotations.NotNull;

public interface SuperSkill extends Skill {
    /**
     * The default cooldown, this would be for any player who had no modifiers
     * Many things can modify the cooldown duration, the default duration is simply as its defined in the users config file
     *
     * @return the default duration for this skills cooldown
     */
    int getDefaultCooldown();

    /**
     * Get the cooldown for a specific player
     * Players can have modifiers that mutate the cooldown length
     * This method will return what cooldown that player would have if the skill just wore off, the duration of time before it could be used again in seconds
     * Due to how permissions work, and the fact that perks for players are permission based, you can only use this on a player who is online
     *
     * @param mmoPlayer target player
     * @return the cooldown of this {@link SuperSkill} for this {@link OnlineMMOPlayer}
     */
    int getCooldown(@NotNull OnlineMMOPlayer mmoPlayer);
}
