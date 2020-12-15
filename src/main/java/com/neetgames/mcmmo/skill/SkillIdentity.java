package com.neetgames.mcmmo.skill;

import org.jetbrains.annotations.NotNull;

public interface SkillIdentity {
    @NotNull String getFullyQualifiedName();

    @NotNull String getNamespace();

    @NotNull String getSkillName();
}
