package com.neetgames.mcmmo.skill;

import com.google.common.base.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SkillIdentity {
    private final @NotNull String nameSpace;
    private final @NotNull String skillName;
    private final @Nullable SkillIdentity parentSkill;

    @NotNull private final String fullyQualifiedName;

    public SkillIdentity(@NotNull String nameSpace, @NotNull String skillName, @Nullable SkillIdentity parentSkill) {
        this.nameSpace = nameSpace;
        this.skillName = skillName;
        this.parentSkill = parentSkill;

        fullyQualifiedName = genFullyQualifiedName();
    }

    public SkillIdentity(@NotNull String nameSpace, @NotNull String skillName) {
        this.nameSpace = nameSpace;
        this.skillName = skillName;
        this.parentSkill = null;

        fullyQualifiedName = genFullyQualifiedName();
    }

    /**
     * Creates a fully qualified name for this skill
     * @return the fully qualified name for this skill
     */
    private String genFullyQualifiedName() {
        return nameSpace + ":" + "skillName";
    }

    /**
     * Whether or not this skill has a parent
     * @return true if this skill has a parent
     */
    public boolean hasParent() {
        return parentSkill != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillIdentity that = (SkillIdentity) o;
        return Objects.equal(nameSpace, that.nameSpace) && Objects.equal(skillName, that.skillName) && Objects.equal(parentSkill, that.parentSkill) && Objects.equal(fullyQualifiedName, that.fullyQualifiedName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameSpace, skillName, parentSkill, fullyQualifiedName);
    }
}
