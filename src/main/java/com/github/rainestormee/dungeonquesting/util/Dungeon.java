package com.github.rainestormee.dungeonquesting.util;

import com.github.rainestormee.dungeonquesting.DungeonQuesting;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Dungeon {

    private Chunk chunk;
    private List<Player> players;
    private long dungeonID;
    private boolean completed;
    private boolean started;
    private World dungeonWorld;
    private DungeonQuesting main;

    Dungeon(Chunk realWorld, List<Player> players, long dungeonID, DungeonQuesting main) {
        this.chunk = realWorld;
        this.players = players;
        this.dungeonID = dungeonID;
        this.completed = false;
        this.started = false;
        this.main = main;
        World template = main.getServer().getWorld("dungeon-template");
        dungeonWorld = main.getServer().createWorld(new WorldCreator("dungeon-" + dungeonID).copy(template));
    }

    Dungeon(Chunk realWorld, DungeonQuesting main) {
        this(realWorld, new ArrayList<>(), new Random().nextLong(), main);
    }

    public void addPlayers(List<Player> players) {
        this.players = players;
    }

    public void spawnGate(int offset) {
        // TODO: The gate is already spawned at this point in time, change logic most likely
        Util.replaceChunk(chunk.getWorld().getChunkAt(0, 0), chunk, offset);
    }

    public Chunk getChunk() {
        return chunk;
    }

    public List<Player> getPlayers() {
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
        players.stream().forEach(u -> {
            u.sendMessage("Teleporting you to another world!");
        });
        this.started = true;
    }

    public boolean hasStarted() {
        return started;
    }

    public void end() {
        this.completed = true;
    }
}