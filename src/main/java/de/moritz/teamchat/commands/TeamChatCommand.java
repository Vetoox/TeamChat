package de.moritz.teamchat.commands;

import de.moritz.teamchat.Teamchat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeamChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        final String blocked = Teamchat.getPrefix() + "§cDazu hast du keine Rechte§7!";
        final Player player = (Player) sender;
        String message = "";

        if(sender instanceof Player) {

            if(player.hasPermission("system.teamchat")) {

                if(args.length >= 1) {

                    for(int i = 0; i < args.length; i++) {
                        message = message + args[i] + " ";
                    }
                    for(Player teamPlayer : Bukkit.getOnlinePlayers()) {
                        if(teamPlayer.hasPermission("system.teamchat")) {
                            teamPlayer.sendMessage(Teamchat.getPrefix() + player.getName() + " §7➟ §r " + message);
                        }
                    }

                } else {
                    player.sendMessage(Teamchat.getPrefix() + "§cbenutze /teamchat <Nachricht>");
                }

            } else {
                player.sendMessage(blocked);
            }
        }

        return false;
    }
}
