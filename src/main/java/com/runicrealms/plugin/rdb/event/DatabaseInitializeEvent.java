package com.runicrealms.plugin.rdb.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Called when the RunicDB has set its implementation of the DatabaseAPI and is ready for use.
 */
public class DatabaseInitializeEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

}
