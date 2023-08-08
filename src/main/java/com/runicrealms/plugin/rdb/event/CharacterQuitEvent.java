package com.runicrealms.plugin.rdb.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * A custom ASYNC event which is called when a player disconnects after selecting a character
 *
 * @author Skyfallin
 */
public class CharacterQuitEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final int slot;
    private final boolean hasLoadedPlayerData;

    /**
     * @param player  who quit
     * @param slot    of the character
     * @param isAsync whether the event should be called async
     */
    public CharacterQuitEvent(final Player player, final int slot, boolean isAsync, boolean hasLoadedPlayerData) {
        super(isAsync);
        this.player = player;
        this.slot = slot;
        this.hasLoadedPlayerData = hasLoadedPlayerData;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public Player getPlayer() {
        return this.player;
    }

    public int getSlot() {
        return this.slot;
    }

    /**
     * A boolean used to check if the user has valid player data in memory, used for item wipe bug debug
     *
     * @return check if the user has valid player data in memory
     */
    public boolean hasLoadedPlayerData() {
        return this.hasLoadedPlayerData;
    }
}
