package br.dev.sno0s.hgplugin.worldgeneration;

import br.dev.sno0s.hgplugin.structures.TrashCleanPopulator;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.codehaus.plexus.util.FileUtils;
import java.io.File;
import java.io.IOException;

public class WorldGeneration {

    public static void execute(JavaPlugin plugin) {
        String worldName = "hg_world";
        File hgDirectory = new File(Bukkit.getServer().getWorldContainer(), worldName);

        Bukkit.getLogger().info("[HardcoreGames] Iniciando geração do mundo!");
        long inicio = System.currentTimeMillis();
        // Se já existe, descarrega e apaga
        if (hgDirectory.exists()) {
            Bukkit.unloadWorld(worldName, false);
            try {
                FileUtils.deleteDirectory(hgDirectory);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // Cria o mundo com biomas que eu quero
        WorldCreator wc = new WorldCreator(worldName);
        wc.environment(World.Environment.NORMAL);
        wc.biomeProvider(new HGWorldProvider());
        World world = Bukkit.createWorld(wc);

        //Bukkit.getLogger().info("[HardcoreGames] Removendo blocos desnecessários.");
        //world.getPopulators().add(new TrashCleanPopulator());

        Bukkit.getLogger().info("[HardcoreGames] Adicionando cogumelos.");
        world.getPopulators().add(new MushroomPopulator());

        // Spawn central
        world.setSpawnLocation(new Location(world, 0, world.getHighestBlockYAt(0, 0) + 10, 0));

        // Agenda a parede alguns ticks depois (evita travar no onEnable)
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            Bukkit.getLogger().info("[HardcoreGames] Gerando bordas.");
            MapComponents.gerarParede(plugin, world, 500);
        }, 40L); // ~2s


        Bukkit.getLogger().info("[HardcoreGames] Setando configurações de clima e tempo.");
        //configs de tempo
        world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        world.setTime(1000);
        //configs de clima
        world.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
        world.setStorm(false);
        world.setThundering(false);

        //tempo final de contagem
        long fim = System.currentTimeMillis();
        long duracao = fim - inicio;

        Bukkit.getLogger().info("Geração do mundo demorou: " + duracao + " ms para rodar.");
    }
}
