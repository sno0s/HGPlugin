package br.dev.sno0s.hgplugin.worldgeneration;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class MapComponents implements Listener {

    public static void gerarParede(JavaPlugin plugin, World world, int tamanho) {
        int half = tamanho / 2;
        int alturaMax = world.getMaxHeight();

        final int[] x = { -half };
        final int[] z = { -half };
        final int step = 10;

        Bukkit.getScheduler().runTaskTimer(plugin, task -> {
            int placed = 0;

            while (x[0] <= half && placed < step) {
                for (int y = 0; y < alturaMax; y++) {
                    world.getBlockAt(x[0], y, -half).setType(Material.BARRIER, false);
                    world.getBlockAt(x[0], y, half).setType(Material.BARRIER, false);
                }
                x[0]++;
                placed++;
            }

            if (x[0] > half) {
                while (z[0] <= half && placed < step) {
                    for (int y = 0; y < alturaMax; y++) {
                        world.getBlockAt(-half, y, z[0]).setType(Material.BARRIER, false);
                        world.getBlockAt(half, y, z[0]).setType(Material.BARRIER, false);
                    }
                    z[0]++;
                    placed++;
                }
            }

            if (z[0] > half) {
                task.cancel();
                Bukkit.getLogger().info("[HardcoreGames] Parede finalizada!");
            }
        }, 0L, 1L);
    }

}
