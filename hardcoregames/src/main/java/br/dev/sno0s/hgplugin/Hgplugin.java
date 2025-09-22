package br.dev.sno0s.hgplugin;

import br.dev.sno0s.hgplugin.commands.CreateHG;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;



public final class Hgplugin extends JavaPlugin {
    private static Hgplugin instance;

    @Override
    public void onEnable()
    {
        instance = this;
    }
    public static Hgplugin getInstance() {
        return instance;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (command.getName().equalsIgnoreCase("createhg"))
            CreateHG.execute(sender);

        return true;
    }


    @Override
    public void onDisable()
    {

    }


}
