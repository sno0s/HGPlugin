package br.dev.sno0s.hgplugin;

import br.dev.sno0s.hgplugin.listeners.PlayerJoinListener;
import br.dev.sno0s.hgplugin.worldgeneration.WorldGeneration;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Hgplugin extends JavaPlugin {

    private static Hgplugin instance;
    private static FileConfiguration config;

    @Override
    public void onEnable()
    {
        Bukkit.getLogger().info("[HardcoreGames] Plugin iniciado!");
        instance = this;

        // puxando a config.yml
        saveDefaultConfig();
        config = getConfig();

        // executando a geração do mundo
        WorldGeneration.execute(this);

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
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

    //retorna a config do plugin
    public static FileConfiguration getPluginConfig(){
        return config;
    }


}
