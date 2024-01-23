package com.runicrealms.plugin.rdb.database;

import org.bukkit.Bukkit;

import java.util.Set;
import java.util.UUID;

public class RunicPlayer {

    private final UUID owner;
    private final PlayerDataHolder data;

    public RunicPlayer(UUID owner, Set<DataHolder> dataHolders) {
        if (Bukkit.isPrimaryThread()) throw new IllegalStateException("Cannot initialize RunicPlayer on main thread!");
        this.owner = owner;
        this.data = new PlayerDataHolder(this, dataHolders);
    }

    public UUID getOwner() {
        return this.owner;
    }

}
