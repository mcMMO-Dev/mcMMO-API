package com.neetgames.mcmmo.player;

import com.neetgames.mcmmo.skill.RootSkill;
import org.jetbrains.annotations.NotNull;

public interface OnlineMMOPlayer extends MMOPlayer {

    boolean inParty();

    boolean isGodMode();

    boolean isChatSpying();

    void togglePartyChatSpying();

    void sendMessage(@NotNull String message);

    boolean hasSkillChatNotifications();
    
    @NotNull Object getServerAPIPlayerImpl();

    void updateXPBar(@NotNull RootSkill rootSkill);
}
