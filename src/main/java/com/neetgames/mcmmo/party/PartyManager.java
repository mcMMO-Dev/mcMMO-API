package com.neetgames.mcmmo.party;

import com.neetgames.mcmmo.player.MMOPlayer;
import com.neetgames.mcmmo.player.OnlineMMOPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;
import java.util.UUID;

//TODO: Rewrite javadoc
//TODO: Refactor
//TODO: Review class
public interface PartyManager {
    /**
     * Attempts to find a party for a player by UUID
     *
     * @param playerUUID target uuid
     * @return the party if it exists otherwise null
     */
    @Nullable Party queryParty(@NotNull UUID playerUUID);

    /**
     * Attempts to find a party by party name
     * Party names are not case sensitive
     *
     * @param partyName party name
     * @return the party if it exists otherwise null
     */
    @Nullable Party queryParty(@NotNull String partyName);

    /**
     * Check if a party with a given name already exists.
     *
     * @param partyName The name of the party to check
     * @return true if a party with that name exists, false otherwise
     */
    boolean isParty(@NotNull String partyName);

    /**
     * Checks if the player can join a party, parties can have a size limit, although there is a permission to bypass this
     *
     * @param player player who is attempting to join the party
     * @param targetParty the target party
     * @return true if party is full and cannot be joined
     */
    boolean isPartyFull(@NotNull OnlineMMOPlayer player, @NotNull Party targetParty);

    /**
     * Attempt to change parties or join a new party.
     *
     * @param mmoPlayer The player changing or joining parties
     * @param newPartyName The name of the party being joined
     * @return true if the party was joined successfully, false otherwise
     */
    boolean changeOrJoinParty(@NotNull OnlineMMOPlayer mmoPlayer, @NotNull String newPartyName);

    /**
     * Check if two online players are in the same party.
     *
     * @param firstPlayer The first player
     * @param secondPlayer The second player
     * @return true if they are in the same party, false otherwise
     */
    boolean inSameParty(@NotNull OnlineMMOPlayer firstPlayer, @NotNull OnlineMMOPlayer secondPlayer);

    /**
     * Get the near party members.
     *
     * @param mmoPlayer The player to check
     * @return the near party members
     */
    @NotNull Set<OnlineMMOPlayer> getNearMembers(@NotNull OnlineMMOPlayer mmoPlayer);

    @NotNull Set<OnlineMMOPlayer> getNearVisibleMembers(@NotNull OnlineMMOPlayer mmoPlayer);

    /**
     * Get a list of all players in this player's party.
     *
     * @param mmoPlayer The player to check
     * @return all the players in the player's party
     */
    @NotNull Set<PartyMember> getAllMembers(@NotNull OnlineMMOPlayer mmoPlayer);

    /**
     * Get a list of all online players in this party.
     *
     * @param partyName The party to check
     * @return all online players in this party
     */
    @NotNull Set<OnlineMMOPlayer> getOnlineMembers(@NotNull String partyName);

    /**
     * Get a list of all online players in this party.
     *
     * @param player The player to check
     * @return all online players in this party
     */
    @NotNull List<PartyMember> getOnlineMembers(@NotNull OnlineMMOPlayer player);

    @NotNull List<PartyMember> getOnlineMembers(@NotNull Party party);

    /**
     * Retrieve a party by its name
     *
     * @param partyName The party name
     * @return the existing party, null otherwise
     */
    @Nullable Party getParty(@NotNull String partyName);

    /**
     * Retrieve a party by a members name
     *
     * @param playerName The members name
     * @return the existing party, null otherwise
     */
    @Deprecated
    @NotNull Party getPlayerParty(@NotNull String playerName);

    /**
     * Retrieve a party by a members uuid
     *
     * @param uuid The members uuid
     * @return the existing party, null otherwise
     */
    @NotNull Party getPlayerParty(UUID uuid);

    /**
     * Retrieve a party by member
     *
     * @param player The member
     * @return the existing party, null otherwise
     */
    @NotNull Party getParty(@NotNull PartyMember player);

    /**
     * Get a list of all current parties.
     *
     * @return the list of parties.
     */
    @NotNull List<Party> getParties();

    /**
     * Remove a player from a party.
     *
     * @param playerUUID The player to remove
     * @param party The party
     */
    void removeFromParty(@NotNull UUID playerUUID, @NotNull Party party);

    /**
     * Remove a player from a party.
     *
     * @param mmoPlayer The player to remove
     */
    void removeFromParty(@NotNull MMOPlayer mmoPlayer);

    /**
     * Disband a party. Kicks out all members and removes the party.
     *
     * @param party The party to remove
     */
    void disbandParty(@NotNull Party party);

    /**
     * Create a new party
     *
     * @param mmoPlayer The player to add to the party
     * @param partyName The party to add the player to
     */
    void createParty(@NotNull OnlineMMOPlayer mmoPlayer, @NotNull String partyName);

    /**
     * Accept a party invitation
     *
     * @param mmoPlayer The player to add to the party
     */
    void joinInvitedParty(@NotNull OnlineMMOPlayer mmoPlayer);

    /**
     * Add a player to a party
     *
     * @param mmoPlayer The player to add to the party
     * @param party The party
     */
    void addToParty(@NotNull OnlineMMOPlayer mmoPlayer, @NotNull Party party);

    /**
     * Check if a player can invite others to his party.
     *
     * @return true if the player can invite
     */
    boolean canInvite(@NotNull OnlineMMOPlayer mmoPlayer);

    /**
     * Remove party data from the mmoPlayer.
     *
     * @param mmoPlayer The player to remove party data from.
     */
    void processPartyLeaving(@NotNull OnlineMMOPlayer mmoPlayer);

    /**
     * Notify party members when the party levels up.
     *
     * @param party The concerned party
     * @param levelsGained The amount of levels gained
     * @param level The current party level
     */
    void informPartyMembersLevelUp(@NotNull Party party, int levelsGained, int level);
}
