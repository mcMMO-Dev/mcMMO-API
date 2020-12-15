package com.neetgames.mcmmo.skill;

import com.google.common.base.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RootSkillImpl implements RootSkill {

    private final @Nullable String permission;
    private final @NotNull SkillIdentity skillIdentity;
    private final @NotNull String skillName;

    public RootSkillImpl(@NotNull String pluginName, @NotNull String skillName, @Nullable String permission) {
        this.permission = permission;
        this.skillName = skillName;

        this.skillIdentity = new SkillIdentityImpl(pluginName, skillName);
    }

    @Override
    public @NotNull SkillIdentity getSkillIdentity() {
        return skillIdentity;
    }

    @Override
    public @Nullable String getPermission() {
        return permission;
    }

    @Override
    public boolean isChildOf(@NotNull SkillIdentity skillIdentity) {
        return false;
    }

    @Override
    public boolean isChildOf(@NotNull RootSkill rootSkill) {
        return false;
    }

    @Override
    public @NotNull String getSkillName() {
        return skillName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RootSkillImpl rootSkill = (RootSkillImpl) o;
        return Objects.equal(skillIdentity, rootSkill.skillIdentity);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(skillIdentity);
    }
}
