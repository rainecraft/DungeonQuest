package com.github.rainestormee.dungeonquesting.util;

import org.bukkit.Chunk;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.*;
import java.util.stream.Collectors;

public class DungeonHandler {

    private List<Dungeon> dungeons;

    public DungeonHandler() {
        dungeons = new ArrayList<>();
    }

    public Dungeon getDungeon(long dungeonID) {
        return dungeons.stream().filter(dungeon -> dungeon.getDungeonID() == dungeonID).findFirst().orElse(null);
    }

    public Dungeon createDungeon(Chunk chunk) {
        Dungeon dungeon = new Dungeon(chunk);
        dungeons.add(dungeon);
        return dungeon;
    }

    public Dungeon spawnGate(Dungeon dungeon, int offset) {
        dungeon.spawnGate(offset);
        return dungeon;
    }

    public Dungeon startDungeon(Dungeon dungeon) {
        Chunk chunk = dungeon.getChunk();
        List<UUID> players = Arrays.stream(chunk.getEntities())
                .filter(e -> e.getType().equals(EntityType.PLAYER))
                .map(Entity::getUniqueId)
                .collect(Collectors.toList());
        dungeon.addPlayers(players);
        dungeon.start();
        return dungeon;
    }

    public void completeDungeon(Dungeon dungeon) {
        dungeon.end();
        // TODO: Implement cleanup
        dungeons.remove(dungeon);
    }
}