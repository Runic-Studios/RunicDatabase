package com.runicrealms.plugin.rdb;

import com.runicrealms.plugin.rdb.api.CharacterAPI;
import com.runicrealms.plugin.rdb.api.ConverterAPI;
import com.runicrealms.plugin.rdb.api.DataAPI;
import com.runicrealms.plugin.rdb.api.RedisAPI;

public interface RunicDatabaseAPI {

    CharacterAPI getCharacterAPI();

    ConverterAPI getConverterAPI();

    DataAPI getDataAPI();

    RedisAPI getRedisAPI();

}
