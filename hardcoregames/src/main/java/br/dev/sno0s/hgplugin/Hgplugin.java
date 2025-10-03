package br.dev.sno0s.hgplugin;

import br.dev.sno0s.hgplugin.listeners.MatchCountDown;
import br.dev.sno0s.hgplugin.listeners.OnDrop;
import br.dev.sno0s.hgplugin.listeners.PlayerJoinListener;
import br.dev.sno0s.hgplugin.listeners.SoupListener;
import br.dev.sno0s.hgplugin.worldgeneration.WorldGeneration;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Hgplugin extends JavaPlugin {

    private static Hgplugin instance;
    private static FileConfiguration config;

    @Override
    public void onEnable()
    {
        // plugin start message
        Bukkit.getLogger().info("[HardcoreGames] Plugin iniciado!");
        instance = this;

        // get config.yml
        saveDefaultConfig();
        config = getConfig();

        // run world generation
        WorldGeneration.execute(this);

        // listeners
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new SoupListener(), this);
        getServer().getPluginManager().registerEvents(new OnDrop(), this);
        getServer().getPluginManager().registerEvents(new MatchCountDown(), this);

        // commands
        getCommand("startmatch").setExecutor(new br.dev.sno0s.hgplugin.commands.StartMatchCommand());
    }

    public static Hgplugin getInstance() {
        return instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        return true;
    }


    @Override
    public void onDisable()
    {
        getLogger().info("Plugin finalizado!");
    }

    // returns plugin config
    public static FileConfiguration getPluginConfig(){
        return config;
    }

    // TODO: find a better class for this
    public static String getServerName() {
        return config.getString("HGconfigs.server-name");
    }
}
