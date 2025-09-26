package br.dev.sno0s.hgplugin.listeners;

import br.dev.sno0s.hgplugin.items.KitSelectorItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        World hgWorld = Bukkit.getWorld("hg_world"); // nome que você usou no WorldGeneration
        if (hgWorld != null) {
            Player player = event.getPlayer();
            Location spawn = hgWorld.getSpawnLocation();

            // mensagem de boas vindas
            Bukkit.broadcast(Component.text(player.getName() + " entrou no servidor.").color(NamedTextColor.GOLD));
            //configs basicas
            player.teleport(spawn); //teleporte ao spawn
            player.setGameMode(GameMode.ADVENTURE); // setando modo adventure para nao quebrar blocos
            player.getInventory().clear(); // cleanando inventario
            player.getInventory().setItem(0, KitSelectorItem.create()); // setando seletor de kits


        }
    }
}
