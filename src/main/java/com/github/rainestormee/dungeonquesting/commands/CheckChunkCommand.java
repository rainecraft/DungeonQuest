package com.github.rainestormee.dungeonquesting.commands;

import com.github.rainestormee.dungeonquesting.util.Util;
import com.github.rainestormee.jdacommand.CommandDescription;
import org.bukkit.entity.Player;

@CommandDescription(name = "check", triggers = "check")
public class CheckChunkCommand extends MinecraftCommand {

    @Override
    public void execute(Player player, String args) {
        if (Util.checkChunk(player)) {
            player.sendMessage("this would be cool to portal and shit from");
        } else {
            player.sendMessage("nah you cant do this one fam");
        }
    }
}
