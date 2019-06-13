package com.github.rainestormee.dungeonquesting.commands;

import com.github.rainestormee.jdacommand.CommandDescription;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@CommandDescription(name = "key", triggers = {"key"})
public class KeyCommand extends MinecraftCommand {

    @Override
    public void execute(Player sender, String args) {
        sender.sendMessage("hello");
        sender.getInventory().addItem(new ItemStack(Material.TRIPWIRE_HOOK, 1));
    }
}
