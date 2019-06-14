package com.github.rainestormee.dungeonquesting.util;

import org.bukkit.Chunk;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static boolean checkChunk(Player player) {
        for (int x = 0; x < 15; x++)
            for (int z = 0; z < 15; z++)
                for (int y = player.getLocation().getBlockY(); y < 255; y++)
                    if (!player.getLocation().getChunk().getBlock(x, y, z).isEmpty())
                        return false;
        return true;
    }

    public static List<Block> replaceChunk(Chunk old, Chunk older, int offset) {
        List<Block> blocks = new ArrayList<>();
        for (int x = 0; x < 15; x++)
            for (int z = 0; z < 15; z++)
                for (int y = 0; y < 255 - offset; y++) {
                    blocks.add(old.getBlock(x, y, z));
                    older.getBlock(x, y + offset, z).setType(old.getBlock(x, y, z).getType());
                }
        return blocks;
    }

    public static void setChunk(Chunk chunk, List<Block> blocks) {
        blocks.forEach(block -> {
            int x = block.getX();
            int y = block.getY();
            int z = block.getZ();
            chunk.getBlock(x, y, z).setBlockData(block.getBlockData());
        });
    }
}
