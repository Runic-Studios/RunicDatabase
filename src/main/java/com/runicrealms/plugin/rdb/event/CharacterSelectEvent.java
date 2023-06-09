package com.runicrealms.plugin.rdb.event;

import com.runicrealms.plugin.rdb.model.SessionDataMongo;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

/**
 * This custom ASYNC event is called when a player first selects a character from the character select screen,
 * before the data is fully loaded to and from redis
 *
 * @author Skyfallin
 */
public class CharacterSelectEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final int slot;
    private final SessionDataMongo corePlayerData;
    private final BukkitTask bukkitTask;
    /*
    Similar to RunicRestart design, our CharacterSelectEvent has a list of plugins which must provide
    a "handshake" for the loaded event to fire
     */
    private final List<String> pluginsToLoadData;
    private boolean isCancelled = false;

    /**
     * @param player         who selected a character
     * @param slot           of the character
     * @param corePlayerData the data of that character (build from redis/mongo async)
     * @param bukkitTask     the title task to display "Loading..."
     */
    public CharacterSelectEvent(Player player, int slot, SessionDataMongo corePlayerData, BukkitTask bukkitTask) {
        super(true);
        this.player = player;
        this.slot = slot;
        this.corePlayerData = corePlayerData;
        this.bukkitTask = bukkitTask;
        this.pluginsToLoadData = new ArrayList<>();
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public BukkitTask getBukkitTask() {
        return bukkitTask;
    }

    public SessionDataMongo getSessionDataMongo() {
        return corePlayerData;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public Player getPlayer() {
        return this.player;
    }

    public List<String> getPluginsToLoadData() {
        return pluginsToLoadData;
    }

    public int getSlot() {
        return slot;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }
}
