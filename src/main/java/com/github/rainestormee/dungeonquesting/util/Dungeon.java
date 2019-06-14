package com.github.rainestormee.dungeonquesting.util;

import org.bukkit.Chunk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Dungeon {

    private Chunk chunk;
    private List<UUID> players;
    private long dungeonID;
    private boolean completed;
    private boolean started;

    Dungeon(Chunk realWorld, List<UUID> players, long dungeonID) {
        this.chunk = realWorld;
        this.players = players;
        this.dungeonID = dungeonID;
        this.completed = false;
        this.started = false;
    }

    Dungeon(Chunk realWorld) {
        this(realWorld, new ArrayList<>(), new Random().nextLong());
    }

    public void addPlayers(List<UUID> players) {
        this.players = players;
    }

    public void spawnGate(int offset) {
        // TODO: The gate is already spawned at this point in time, change logic most likely
        Util.replaceChunk(chunk.getWorld().getChunkAt(0, 0), chunk, offset);
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

    public void start() {
        // TODO: Teleport players to the multi-verse containing the dungeon.
        this.started = true;
    }

    public boolean hasStarted() {
        return started;
    }

    public void end() {
        this.completed = true;
    }
}