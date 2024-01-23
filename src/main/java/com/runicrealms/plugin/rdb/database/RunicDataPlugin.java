package com.runicrealms.plugin.rdb.database;

import com.runicrealms.plugin.common.plugin.RunicPlugin;

import java.util.UUID;
import java.util.function.Function;

public abstract class RunicDataPlugin extends RunicPlugin {

    public void registerPlayerDataHandler(Function<UUID, DataHolder> constructor) {

    }

}
