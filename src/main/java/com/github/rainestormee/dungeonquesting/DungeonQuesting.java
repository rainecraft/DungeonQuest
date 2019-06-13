package com.github.rainestormee.dungeonquesting;

import com.github.rainestormee.dungeonquesting.commands.CommandExecutor;
import com.github.rainestormee.dungeonquesting.event.DungeonGateSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class DungeonQuesting extends JavaPlugin {

    private Logger logger;

    @Override
    public void onEnable() {
        logger = this.getLogger();
        logger.info("DungeonQuesting is starting up!");
        try {
            logger.info("DungeonQuesting has finished starting!");
            this.getCommand("dq").setExecutor(new CommandExecutor());
            this.getServer().getPluginManager().registerEvents(new DungeonGateSpawnEvent(), this);
        } catch (Exception ignored) {
            logger.severe("Error while starting DungeonQuesting!");
        }

        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        logger.info("DungeonQuesting is shutting down.");
        logger.info("DungeonQuestion has finished stopping.");
        // Plugin shutdown logic
    }
}
