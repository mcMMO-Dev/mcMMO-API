package com.neetgames.mcmmo.party;

import com.neetgames.mcmmo.player.OnlineMMOPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.UUID;

public interface Party {
    @NotNull PartyMemberManager getPartyMemberManager();

    @NotNull PartyMemberManager getPartyExperienceManager();

    @NotNull Set<PartyMember> getPartyMembers();

    @NotNull String getPartyName();

    @Nullable PartyMember getPartyMember(@NotNull OnlineMMOPlayer mmoPlayer);

    @Nullable PartyMember getPartyMember(@NotNull UUID playerUUID);
}
