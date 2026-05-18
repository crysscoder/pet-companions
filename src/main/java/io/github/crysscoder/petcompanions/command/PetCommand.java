package io.github.crysscoder.petcompanions.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import io.github.crysscoder.petcompanions.command.subcommand.SubCommand;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PetCommand implements CommandExecutor {
    private final Map<String, SubCommand> subCommands = new HashMap<>();

    public void register(SubCommand cmd) {
        subCommands.put(cmd.getName().toLowerCase(), cmd);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player player)) return true;

        if (args.length == 0) {
            player.sendMessage("Используйте /pet <subcommand>");
            return true;
        }

        SubCommand cmd = subCommands.get(args[0].toLowerCase());
        if (cmd == null) {
            player.sendMessage("Неизвестная команда!");
            return true;
        }

        cmd.execute(player, Arrays.copyOfRange(args, 1, args.length));
        return true;
    }
}
