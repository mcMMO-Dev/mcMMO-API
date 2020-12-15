package com.neetgames.mcmmo.skill;

import com.google.common.base.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

public class SkillIdentityImpl implements SkillIdentity {
    public static final String SKILL_NAMESPACE_SEPARATOR = ".";
    private final @NotNull String nameSpace;
    private final @NotNull String skillName;
    private final @Nullable SkillIdentity parentSkill;

    @NotNull private final String fullyQualifiedName;

    //TODO: Don't allow parameters to have certain characters like .
    public SkillIdentityImpl(@NotNull String nameSpace, @NotNull String skillName, @Nullable SkillIdentity parentSkill) {
        this.nameSpace = nameSpace.toLowerCase(Locale.ENGLISH);
        this.skillName = skillName.toLowerCase(Locale.ENGLISH);
        this.parentSkill = parentSkill;

        fullyQualifiedName = genFullyQualifiedName();
    }

    //TODO: Don't allow parameters to have certain characters like .
    public SkillIdentityImpl(@NotNull String nameSpace, @NotNull String skillName) {
        this.nameSpace = nameSpace;
        this.skillName = skillName;
        this.parentSkill = null;

        fullyQualifiedName = genFullyQualifiedName();
    }

    /**
     * Creates a fully qualified name for this skill
     *
     * @return the fully qualified name for this skill
     */
    private @NotNull String genFullyQualifiedName() {
        StringBuilder stringBuilder = new StringBuilder();

        if(parentSkill != null) {
            stringBuilder
                    .append(parentSkill.getFullyQualifiedName())
                    .append(SKILL_NAMESPACE_SEPARATOR)
                    .append(skillName);
        } else {
            stringBuilder.append(nameSpace)
                    .append(SKILL_NAMESPACE_SEPARATOR)
                    .append(skillName);
        }

        return stringBuilder.toString();
    }

    public @NotNull String getFullyQualifiedName() {
        return fullyQualifiedName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillIdentityImpl that = (SkillIdentityImpl) o;
        return Objects.equal(fullyQualifiedName, that.fullyQualifiedName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fullyQualifiedName);
    }
}
