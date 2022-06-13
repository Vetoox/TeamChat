package de.moritz.teamchat;

import de.moritz.teamchat.commands.TeamChatCommand;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Teamchat extends JavaPlugin {

    @Getter
    private static volatile Teamchat instance;

    @Getter
    private static String prefix = "§cTeamChat §f| §r";

    @Override
    public void onEnable() {
        instance=this;

        getCommand("tc").setExecutor(new TeamChatCommand());
        getCommand("teamchat").setExecutor(new TeamChatCommand());
    }

    @Override
    public void onDisable() {
        instance=null;
    }
}
