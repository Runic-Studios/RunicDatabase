package com.runicrealms.plugin.rdb.database;

import com.runicrealms.plugin.rdb.database.exception.DataLoadException;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class DataHandlerManager implements DataHandlerAPI {

    private static Set<DataHolderConstructor> handlerConstructors = new HashSet<>();

    @Override
    public void registerPlayerDataHolder(DataHolderConstructor constructor) {
        handlerConstructors.add(constructor);
    }

    @Override
    public RunicPlayer constructPlayer(Player player) throws DataLoadException {
        Set<DataHolder> handlers = new HashSet<>();
        for (DataHolderConstructor handlerConstructor : handlerConstructors) {
            handlers.add(handlerConstructor.constructHandler(player.getUniqueId()));
        }
        return new RunicPlayer(player.getUniqueId(), handlers);
    }

}
