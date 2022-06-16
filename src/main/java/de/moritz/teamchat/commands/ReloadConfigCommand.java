package de.moritz.teamchat.commands;

import de.moritz.teamchat.Teamchat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadConfigCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        final Player player = (Player) sender;

        if(sender instanceof Player) {
            if(player.hasPermission(Teamchat.getPermission())) {
                Teamchat.getInstance().reloadConfig();
                Teamchat.getInstance().loadConfig();
                player.sendMessage(Teamchat.getPrefix() + "§aConfig wurde neugeladen");
            } else {
                player.sendMessage(Teamchat.getPrefix() + "§cDazu hast du keine Rechte§7!");
            }
        }


        return false;
    }
}
