package com.neetgames.mcmmo.experience.context;

import com.neetgames.mcmmo.player.OnlineMMOPlayer;
import org.jetbrains.annotations.NotNull;

public interface SharedExperienceContext {
    /**
     * The {@link OnlineMMOPlayer} who originally gained the XP that was then shared
     * @return the {@link OnlineMMOPlayer} to which this experience context originates
     */
    @NotNull OnlineMMOPlayer getSharedContextSource();
}
