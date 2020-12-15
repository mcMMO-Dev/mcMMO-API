package com.neetgames.mcmmo.skill;

import org.jetbrains.annotations.Nullable;

public interface Permissive {
    /**
     * The {@link String permission} address
     * This should be the permission node that either enables or disables the skill completely
     *
     * @return the permission address
     */
    @Nullable String getPermission();
}
