package com.runicrealms.plugin.rdb.database;

import com.runicrealms.plugin.rdb.database.exception.DataHandlerConstructionException;

import java.util.UUID;

public interface DataHolderConstructor {

    DataHolder constructHandler(UUID owner) throws DataHandlerConstructionException;

}
