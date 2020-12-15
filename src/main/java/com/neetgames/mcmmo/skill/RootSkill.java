package com.neetgames.mcmmo.skill;

import org.jetbrains.annotations.Nullable;

public interface RootSkill extends Skill {
    default @Override @Nullable Skill getParent() {
        return null;
    }

    default @Override boolean hasParent() { return false; }
}
