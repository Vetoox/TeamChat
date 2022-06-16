package de.moritz.teamchat;

import de.moritz.teamchat.commands.ReloadConfigCommand;
import de.moritz.teamchat.commands.TeamChatCommand;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Teamchat extends JavaPlugin {

    @Getter
    private static volatile Teamchat instance;

    @Getter
    private static String prefix = "§cTeamChat §f| §r";
    @Getter
    private static String permission = "system.teamchat";

    @Override
    public void onEnable() {
        saveDefaultConfig();
        instance=this;

        getCommand("tc").setExecutor(new TeamChatCommand());
        getCommand("teamchat").setExecutor(new TeamChatCommand());
        getCommand("tc-reload").setExecutor(new ReloadConfigCommand());
        getCommand("teamchat-reload").setExecutor(new ReloadConfigCommand());

        loadConfig();

    }

    public void loadConfig() {

        String configPrefix;

        configPrefix = getConfig().getString("prefix");
        permission = getConfig().getString("permission");

        prefix = configPrefix.replace("&", "§");

    }

    @Override
    public void onDisable() {
        saveDefaultConfig();
        instance=null;
    }
}
