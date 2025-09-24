package br.dev.sno0s.hgplugin.listeners;

import br.dev.sno0s.hgplugin.items.KitSelectorItem;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        World hgWorld = Bukkit.getWorld("hg_world"); // nome que você usou no WorldGeneration
        if (hgWorld != null) {
            Player player = event.getPlayer();
            Location spawn = hgWorld.getSpawnLocation();

            //configs basicas
            player.teleport(spawn); //teleporte ao spawn
            player.setInvulnerable(true); // invencibilidade
            player.getInventory().clear(); // cleanando inventario
            player.getInventory().setItem(0, KitSelectorItem.create()); // setando seletor de kits

        }
    }
}
