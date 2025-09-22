package br.dev.sno0s.hgplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.Location;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        World hgWorld = Bukkit.getWorld("hg_world"); // nome que você usou no WorldGeneration
        if (hgWorld != null) {
            Location spawn = hgWorld.getSpawnLocation();
            event.getPlayer().teleport(spawn);
        }
    }
}
