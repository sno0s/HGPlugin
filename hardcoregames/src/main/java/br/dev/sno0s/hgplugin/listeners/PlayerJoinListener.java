package br.dev.sno0s.hgplugin.listeners;

import br.dev.sno0s.hgplugin.Hgplugin;

import br.dev.sno0s.hgplugin.utils.PlayerJoinItems;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.Location;

public class PlayerJoinListener implements Listener {

    /*
        this method do:
        - get the world that the game will start
        - show welcome message
        - teleport the player to spawn
        - set gamemode adventure, prevent the player to break blocks
        - set player join items
     */

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        World hgWorld = Bukkit.getWorld("hg_world");
        if (hgWorld != null) {
            Player player = event.getPlayer();
            Location spawn = hgWorld.getSpawnLocation();

            // welcome message
            Bukkit.broadcastMessage(Hgplugin.serverName + " §f" + player.getName() + " §eEntrou no servidor!");

            //basic configs
            player.teleport(spawn);
            player.setGameMode(GameMode.ADVENTURE);
            player.getInventory().clear();
            PlayerJoinItems.give(player);

        }
    }
}
