package com.neetgames.mcmmo.party;

/**
 * A list of reasons why the event may have been fired
 */
public enum PartyEventReason {
    /**
     * Joined a party for the first time.
     */
    JOINED_PARTY,

    /**
     * Left a party and did not join a new one.
     */
    LEFT_PARTY,

    /**
     * Was kicked from a party.
     */
    KICKED_FROM_PARTY,

    /**
     * Left one party to join another.
     */
    CHANGED_PARTIES,

    /**
     * Any reason that doesn't fit elsewhere.
     */
    CUSTOM
}
