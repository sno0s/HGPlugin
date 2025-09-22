package br.dev.sno0s.hgplugin.commands;

import br.dev.sno0s.hgplugin.Hgplugin;
import br.dev.sno0s.hgplugin.structures.MushroomPopulator;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.codehaus.plexus.util.FileUtils;

import java.io.File;
import java.io.IOException;

import static br.dev.sno0s.hgplugin.structures.MainMap.gerarParede;

public class CreateHG {

    public static void execute(CommandSender pSender) {
        File hgDirectory = new File(Bukkit.getServer().getWorldContainer(), "hardcoregames");

        if (pSender instanceof Player player) {

            if (hgDirectory.exists()) {
                player.sendMessage("[HardcoreGames] " + ChatColor.RED + "Mundo já existe! Apagando diretório.");
                Bukkit.unloadWorld("hardcoregames", false);
                try {
                    FileUtils.deleteDirectory(hgDirectory);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            player.sendMessage("[HardcoreGames] " + ChatColor.GREEN + "Gerando novo mundo de testes!");

            // fluxo de criação do mundo
            WorldCreator wc = new WorldCreator("hardcoregames");
            wc.environment(World.Environment.NORMAL);

            // cria o mundo vanilla
            World world = Bukkit.createWorld(wc);

            // registra seu populator
            world.getPopulators().add(new MushroomPopulator());

            // já define o spawn no centro
            world.setSpawnLocation(new Location(world, 0, world.getHighestBlockYAt(0, 0) + 10, 0));

            // chama a função que vai criar a parede

            gerarParede(Hgplugin.getInstance(),world, 500);

            player.sendMessage("[HardcoreGames] " + ChatColor.GREEN + "Mundo gerado com sucesso!");
        }
    }
}
