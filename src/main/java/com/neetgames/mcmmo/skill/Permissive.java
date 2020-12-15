package com.neetgames.mcmmo.skill;

import org.jetbrains.annotations.Nullable;

public interface Permissive {
    /**
     * The {@link String permission} address
     * @return the permission address
     */
    @Nullable String getPermission();
}
