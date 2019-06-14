package com.github.rainestormee.dungeonquesting.event;

import com.github.rainestormee.dungeonquesting.util.Dungeon;
import com.github.rainestormee.dungeonquesting.util.DungeonHandler;
import com.github.rainestormee.dungeonquesting.util.Util;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

public class DungeonGateSpawnEvent implements Listener {

    private Plugin plugin;

    public DungeonGateSpawnEvent(Plugin main) {
        this.plugin = main;
    }

    @EventHandler
    public void dungeonDateSpawnEvent(PlayerDropItemEvent event) {
        Location loc = event.getPlayer().getLocation();
        if (!event.getItemDrop().getItemStack().getType().equals(Material.TRIPWIRE_HOOK)
                || !Util.checkChunk(event.getPlayer())
                || event.getPlayer().getWorld().getBlockAt(loc.getBlockX(), loc.getBlockY() - 1, loc.getBlockZ()).isEmpty()) {
            return;
        }
        event.getItemDrop().remove();
        event.getPlayer().sendMessage("This is a definite thing so lets go boi!");
        Dungeon dungeon = new DungeonHandler().createDungeon(loc.getChunk());
        dungeon.spawnGate(event.getPlayer().getLocation().getBlockY());
        event.getPlayer().getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            dungeon.addPlayers(Arrays.stream(loc.getChunk().getEntities())
                    .filter(e -> e.getType().equals(EntityType.PLAYER))
                    .map(Entity::getUniqueId).collect(Collectors.toList()));
            dungeon.start();
        }, 30 * 1000L);
    }
}
