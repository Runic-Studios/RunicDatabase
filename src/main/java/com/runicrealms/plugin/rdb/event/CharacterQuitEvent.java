package com.runicrealms.plugin.rdb.event;

import com.runicrealms.plugin.rdb.model.SessionDataRedis;
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
    private final SessionDataRedis coreCharacterData;

    /**
     * @param player  who quit
     * @param slot    of the character
     * @param isAsync whether the event should be called async
     */
    public CharacterQuitEvent(final Player player, final int slot, final SessionDataRedis coreCharacterData, boolean isAsync) {
        super(isAsync);
        this.player = player;
        this.slot = slot;
        this.coreCharacterData = coreCharacterData;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public SessionDataRedis getSessionDataRedis() {
        return this.coreCharacterData;
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

}
