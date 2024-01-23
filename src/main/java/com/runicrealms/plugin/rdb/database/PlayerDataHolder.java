package com.runicrealms.plugin.rdb.database;

import java.util.Set;

public class PlayerDataHolder implements MultiDataHolder {

    private final RunicPlayer player;
    private final Set<DataHolder> dataHolders;

    public PlayerDataHolder(RunicPlayer player, Set<DataHolder> dataHolders) {
        this.player = player;
        this.dataHolders = dataHolders;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends DataHolder> T getHolder(Class<T> type) {
        for (DataHolder handler : dataHolders) {
            if (type.isInstance(handler)) {
                return (T) handler;
            }
        }
        throw new IllegalArgumentException("MultiDataHandler does not have DataHandler with type " + type.getName());
    }

}
