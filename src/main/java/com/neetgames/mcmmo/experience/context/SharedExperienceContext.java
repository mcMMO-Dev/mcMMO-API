package com.neetgames.mcmmo.experience.context;

import com.neetgames.mcmmo.player.OnlinePlayer;
import org.jetbrains.annotations.NotNull;

public interface SharedExperienceContext {
    /**
     * The {@link OnlinePlayer} who originally gained the XP that was then shared
     * @return the {@link OnlinePlayer} to which this experience context originates
     */
    @NotNull OnlinePlayer getSharedContextSource();
}
