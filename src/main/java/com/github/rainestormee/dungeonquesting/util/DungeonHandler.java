package com.github.rainestormee.dungeonquesting.util;

import org.bukkit.Chunk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class DungeonHandler {

    private List<Dungeon> dungeons;

    public DungeonHandler() {
        dungeons = new ArrayList<>();
    }

    public Dungeon getDungeon(long dungeonID) {
        return dungeons.stream().filter(dungeon -> dungeon.getDungeonID() == dungeonID).findFirst().orElse(null);
    }

    public Dungeon startDungeon(Chunk chunk, List<UUID> players, int offset) {
        Dungeon dungeon = new Dungeon(chunk, players, new Random().nextLong());
        dungeons.add(dungeon);
        // TODO: Setup Dungeon
        Util.replaceChunk(chunk.getWorld().getChunkAt(0, 0), chunk, offset);
        return dungeon;
    }

    public void completeDungeon(long dungeonID) {
        Dungeon dungeon = this.getDungeon(dungeonID);
        if (dungeon == null) return;
        dungeon.end();
        // TODO: Implement cleanup
        dungeons.remove(dungeon);
    }
}