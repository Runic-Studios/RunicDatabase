package com.runicrealms.plugin.rdb;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class RunicDatabase extends JavaPlugin {

    private static RunicDatabase instance;

    private String databaseName;
    private String connectionString;

    private RunicDatabaseAPI databaseAPI;

    @Override
    public void onEnable() {
        instance = this;
        this.getConfig().addDefault("database", "writer");
        this.saveDefaultConfig();

        databaseName = this.getConfig().getString("database");
        if (databaseName == null) throw new IllegalStateException("Missing database name! Aborting startup.");
        connectionString = this.getConfig().getString("connection-string");
        if (connectionString == null) throw new IllegalStateException("Missing connection string! Aborting startup.");

        Bukkit.getLogger().log(Level.INFO, "[RunicDatabase] Loaded RunicDatabase");
    }


    public void setAPIImplementation(RunicDatabaseAPI databaseAPI) {
        this.databaseAPI = databaseAPI;
    }

    public static RunicDatabaseAPI getAPI() {
        if (getInstance().databaseAPI == null) throw new IllegalStateException("Attempting to access RunicDatabaseAPI before Core has defined its implementation!");
        return getInstance().databaseAPI;
    }

    public static RunicDatabase getInstance() {
        return instance;
    }

    public static String getDatabaseName() {
        return getInstance().databaseName;
    }

    public static String getConnectionString() {
        return getInstance().connectionString;
    }

}
