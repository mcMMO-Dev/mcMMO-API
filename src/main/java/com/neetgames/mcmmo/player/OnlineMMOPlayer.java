package com.neetgames.mcmmo.player;

import org.jetbrains.annotations.NotNull;

public interface OnlineMMOPlayer extends MMOPlayer {

    boolean inParty();

    boolean isGodMode();

    boolean isChatSpying();

    void sendMessage(@NotNull String message);

    boolean hasSkillChatNotifications();
    
    @NotNull Object getServerAPIPlayerImpl();
}
