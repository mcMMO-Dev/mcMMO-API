package com.neetgames.mcmmo.skill;

import com.google.common.base.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SkillImpl implements Skill {

    private final @Nullable RootSkill parentSkill;
    private final @Nullable String permission;
    private final @NotNull SkillIdentity skillIdentity;
    private final @NotNull String skillName;

    public SkillImpl(@NotNull RootSkill parentSkill, @Nullable String permission, @NotNull String pluginName, @NotNull String skillName) {
        this.parentSkill = parentSkill;
        this.permission = permission;
        this.skillName = skillName;

        this.skillIdentity = new SkillIdentityImpl(pluginName, skillName, parentSkill);
    }

    public SkillImpl(@Nullable String permission, @NotNull String pluginName, @NotNull String skillName) {
        this.permission = permission;
        this.skillName = skillName;
        this.parentSkill = null;

        this.skillIdentity = new SkillIdentityImpl(pluginName, skillName);
    }

    @Override
    public @Nullable String getPermission() {
        return permission;
    }

    @Override
    public @Nullable Skill getParent() {
        return parentSkill;
    }

    @Override
    public @NotNull SkillIdentity getSkillIdentity() {
        return skillIdentity;
    }

    @Override
    public boolean isParent(@NotNull SkillIdentity skillIdentity) {
        if(parentSkill == null)
            return false;
        else return skillIdentity.equals(parentSkill.getSkillIdentity());
    }

    @Override
    public boolean isParent(@NotNull RootSkill rootSkill) {
        if(parentSkill == null)
            return false;
        else return skillIdentity.equals(parentSkill.getSkillIdentity());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillImpl that = (SkillImpl) o;
        return Objects.equal(skillIdentity, that.skillIdentity);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(skillIdentity);
    }
}