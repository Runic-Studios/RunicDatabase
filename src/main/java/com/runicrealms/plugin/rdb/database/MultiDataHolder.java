package com.runicrealms.plugin.rdb.database;

public interface MultiDataHolder {

    <T extends DataHolder> T getHolder(Class<T> type);

}
