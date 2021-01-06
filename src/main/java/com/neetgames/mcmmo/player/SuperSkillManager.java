package com.neetgames.mcmmo.player;

import com.neetgames.mcmmo.skill.AbilityToolType;
import com.neetgames.mcmmo.skill.RootSkill;
import com.neetgames.mcmmo.skill.SuperSkill;
import org.jetbrains.annotations.NotNull;

//TODO: Write javadocs
//TODO: Refactor method names / parameters
//TODO: Rework
public interface SuperSkillManager {
    void processAbilityActivation(RootSkill rootSkill);

    //TODO: Change this to be specific to super skills, not the root skill
    void checkAbilityActivation(@NotNull RootSkill rootSkill);

    void disableSuperAbilities();

    void resetCooldowns();

    boolean getAbilityMode(@NotNull SuperSkill superSkill);

    void setAbilityMode(@NotNull SuperSkill superSkill, boolean isActive);

    boolean getAbilityInformed(@NotNull SuperSkill superSkill);

    void setAbilityInformed(@NotNull SuperSkill superSkill, boolean isInformed);

    boolean isAbilityToolPrimed(@NotNull AbilityToolType abilityToolType);

    boolean getAbilityActivationPermission();

    void toggleAbilityActivationPermission();

    void unprimeAllAbilityTools();

    void setAbilityToolPrime(@NotNull AbilityToolType abilityToolType, boolean isPrepared);

    int calculateTimeRemaining(@NotNull SuperSkill superSkill);
}
