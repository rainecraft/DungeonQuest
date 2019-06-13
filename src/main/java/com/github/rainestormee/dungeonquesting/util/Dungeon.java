package com.github.rainestormee.dungeonquesting.util;

import org.bukkit.Chunk;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Dungeon {

    private Chunk chunk;
    private List<UUID> players;
    private long dungeonID;
    private boolean completed;

    Dungeon(Chunk realWorld, List<UUID> players, long dungeonID) {
        this.chunk = realWorld;
        this.players = players;
        this.dungeonID = dungeonID;
        this.completed = false;
    }

    public void spawnGate() {

    }

    public Chunk getChunk() {
        return chunk;
    }

    public List<UUID> getPlayers() {
        return players;
    }

    public long getDungeonID() {
        return dungeonID;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void end() {
        this.completed = true;
    }
}