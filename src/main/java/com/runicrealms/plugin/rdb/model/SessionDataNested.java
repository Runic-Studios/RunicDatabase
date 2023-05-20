package com.runicrealms.plugin.rdb.model;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * This interface is a slightly different variant of SessionDataRedis for data modeling that is embedded deeply in jedis
 * Current plugin uses: items, achievements, quests
 *
 * @author Skyfallin
 */
public interface SessionDataNested {

    /**
     * Method to return some data from jedis as a map of key-value pairs
     *
     * @param jedis        the jedis resource
     * @param nestedObject some nested object to get the data map for
     * @param slot         an optional character slot for character-specific data
     * @return a map of key-value pairs
     */
    Map<String, String> getDataMapFromJedis(Jedis jedis, Object nestedObject, int... slot);

    /**
     * @return a list of jedis fields
     */
    List<String> getFields();

    /**
     * @return the Player's UUID that keys this nested section in Redis
     */
    UUID getUuid();

    /**
     * Different implementation of toMap that allows for a nested object
     *
     * @param nestedObject some nested object to set the data map for
     * @return a map of key-value pairs of data on the nested object
     */
    Map<String, String> toMap(Object nestedObject);

    /**
     * Ensures that all session data has a method to save the data in jedis
     *
     * @param jedis the jedis resource
     * @param slot  an optional argument to represent the character slot (for alt-specific data)
     */
    void writeToJedis(Jedis jedis, int... slot);

}
