package com.runicrealms.plugin.rdb.api;

import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Set;
import java.util.UUID;

public interface DataAPI {

    /**
     * @return the database specified in config (live, dev, etc.)
     */
    MongoDatabase getMongoDatabase();

    /**
     * Returns the single instance of the mongo template.
     * It's thread-safe
     *
     * @return a MongoTemplate using our MongoClient and MongoDatabase
     */
    MongoTemplate getMongoTemplate();

    /**
     * @return The max char slot, which is how many characters we can have in the game
     * * e.g. 10
     */
    int getMaxCharacterSlot();

    /**
     * Used when data is saved to prevent rapidly re-joining the game
     *
     * @param uuid of player to lockout
     */
    void preventLogin(UUID uuid);

    /**
     * @return a set of players whose data is saving and should not be allowed to join the server
     */
    Set<UUID> getLockedOutPlayers();

}
