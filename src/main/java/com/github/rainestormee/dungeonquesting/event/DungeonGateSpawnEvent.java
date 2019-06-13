package com.github.rainestormee.dungeonquesting.event;

import com.github.rainestormee.dungeonquesting.util.DungeonHandler;
import com.github.rainestormee.dungeonquesting.util.Util;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import java.util.ArrayList;
import java.util.UUID;

public class DungeonGateSpawnEvent implements Listener {

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
        new DungeonHandler().startDungeon(loc.getChunk(), new ArrayList<UUID>() {{
            add(event.getPlayer().getUniqueId());
        }}, event.getPlayer().getLocation().getBlockY() - 65);
    }
}
