package com.runicrealms.plugin.rdb.database;

import com.runicrealms.plugin.rdb.database.exception.DataHandlerSaveException;

public interface DataHolder {

    void save() throws DataHandlerSaveException;

    boolean isLoaded();

}
