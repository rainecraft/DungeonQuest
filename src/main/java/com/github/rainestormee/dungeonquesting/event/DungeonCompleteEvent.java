package com.github.rainestormee.dungeonquesting.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class DungeonCompleteEvent extends Event {

    private HandlerList handlerList = new HandlerList();

    public DungeonCompleteEvent() {
        super();
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
