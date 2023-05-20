package com.runicrealms.plugin.rdb.model;

public interface SessionDataMongo {

    /**
     * Ensure that all session data has a method to save the data in mongo
     */
    <T> T addDocumentToMongo();
}
