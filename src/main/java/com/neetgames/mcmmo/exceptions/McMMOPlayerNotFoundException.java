package com.neetgames.mcmmo.exceptions;

import com.neetgames.jmal.core.player.Player;
import org.jetbrains.annotations.NotNull;

public class McMMOPlayerNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 761917904993202836L;

    public McMMOPlayerNotFoundException(@NotNull Player player) {
        super("McMMOPlayer object was not found for [NOTE: This can mean the profile is not loaded yet!] : " + player.getName() + " " + player.getIdentity());
    }
}
