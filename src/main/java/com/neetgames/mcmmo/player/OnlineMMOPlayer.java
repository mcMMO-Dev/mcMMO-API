package com.neetgames.mcmmo.player;

import com.neetgames.mcmmo.party.Party;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface OnlineMMOPlayer extends MMOPlayer {

    boolean inParty();

    boolean isGodMode();

    boolean isChatSpying();

    void togglePartyChatSpying();

    void sendMessage(@NotNull String message);

    boolean hasSkillChatNotifications();
    
    @NotNull Object getServerAPIPlayerImpl();

    @Nullable Party getParty();

    /**
     * Checks if a player should have god mode or not, and removes god mode if not.
     */
    void validateGodMode();

    /**
     * Check if a player should be in a party or not, and removes them if they should not
     */
    void validateParty();

    /**
     * Check a permission for this player
     *
     * @param permissionAddress the address of the permission
     * @return true if player has permission
     */
    boolean hasPermission(@NotNull String permissionAddress);

}
