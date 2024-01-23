package com.runicrealms.plugin.rdb.database;

import org.bukkit.entity.Player;

public interface DataHandlerAPI {

    void registerPlayerDataHolder(DataHolderConstructor constructor);

    RunicPlayer constructPlayer(Player player);

}
