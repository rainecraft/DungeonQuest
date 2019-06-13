package com.github.rainestormee.dungeonquesting.commands;

import com.github.rainestormee.jdacommand.CommandHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandExecutor implements org.bukkit.command.CommandExecutor {

    private CommandHandler<Player> commandHandler;

    public CommandExecutor() {
        commandHandler = new CommandHandler<>();
        commandHandler.registerCommands(
                new KeyCommand(),
                new ClearChunkCommand(),
                new CheckChunkCommand()
        );
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args == null || args.length == 0) return false;
        commandHandler.findAndExecute(args[0], (Player) sender, String.join(" ", args).replaceFirst(args[0], "").trim());
        return false;
    }
}
