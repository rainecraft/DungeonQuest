package com.github.rainestormee.dungeonquesting.commands;

import com.github.rainestormee.jdacommand.CommandDescription;
import org.bukkit.Material;
import org.bukkit.entity.Player;

@CommandDescription(name = "ClearChunk", triggers = {"clear"})
public class ClearChunkCommand extends MinecraftCommand {

    @Override
    public void execute(Player player, String args) {
        for (int x = 0; x < 15; x++)
            for (int z = 0; z < 15; z++)
                for (int y = player.getLocation().getBlockY(); y < 255; y++)
                    player.getLocation().getChunk().getBlock(x, y, z).setType(Material.AIR);
    }
}
