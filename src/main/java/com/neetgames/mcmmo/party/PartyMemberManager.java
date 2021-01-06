package com.neetgames.mcmmo.party;

import com.neetgames.mcmmo.player.MMOPlayer;
import com.neetgames.mcmmo.player.OnlineMMOPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface PartyMemberManager {
    /**
     * Grab all party members for this party
     *
     * @return all party members
     */
    @NotNull Set<PartyMember> getPartyMembers();

    /**
     * Grab a specific {@link PartyMember} by {@link UUID}
     *
     * @param playerUUID target UUID
     * @return the party member if they exist, otherwise null
     */
    @Nullable PartyMember getPartyMember(@NotNull UUID playerUUID);

    /**
     * Add a {@link PartyMember} to this {@link Party} with a designated rank
     * If you are adding a {@link PartyMemberRank} of Leader, any existing party leaders will be demoted to a regular member of the party
     *
     * @param playerUUID target player's uuid
     * @param partyMemberRank target rank
     */
    void addPartyMember(@NotNull UUID playerUUID, @NotNull PartyMemberRank partyMemberRank);

    /**
     * Get party members that are "Visible" to a target {@link OnlineMMOPlayer}
     *
     * @param mmoPlayer target {@link OnlineMMOPlayer}
     * @return returns a {@link HashSet <PartyMember>} which are visible to the player
     */
    @NotNull HashSet<PartyMember> getVisibleMembers(@NotNull OnlineMMOPlayer mmoPlayer);

    /**
     * Change the leader of a party to the provided UUID
     *
     * @param playerUUID the UUID of the new party leader
     */
    void changeLeader(@NotNull UUID playerUUID) throws RuntimeException;

    /**
     * Retrieves a party leader, if one doesn't exist a "random" player is forcibly promoted to leader
     * Random being the first player in the set
     *
     * @return the party leader
     */
    @NotNull PartyMember getPartyLeader();

    boolean hasMember(@NotNull UUID playerUUID);

    boolean hasMember(@NotNull MMOPlayer player);

    /**
     * Checks for a party member by player name, this method is unreliable and should be avoided.
     * Not case sensitive
     *
     * @param playerName target player name
     * @return true if the a matching player is found
     * @deprecated Unreliable, use UUID instead
     */
    @Deprecated
    boolean hasMember(@NotNull String playerName);

    /**
     * Get the near party members.
     *
     * @param mmoPlayer The player to check
     * @return the near party members
     */
    @NotNull List<OnlineMMOPlayer> getNearMembers(@NotNull OnlineMMOPlayer mmoPlayer);
}
