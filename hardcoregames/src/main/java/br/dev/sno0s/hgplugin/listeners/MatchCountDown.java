package br.dev.sno0s.hgplugin.listeners;

import br.dev.sno0s.hgplugin.Hgplugin;
import br.dev.sno0s.hgplugin.modules.StartMatch;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class MatchCountDown implements Listener {

    /*
        this method will see if the match can be started,
        then will set the initial configurations
     */
    @EventHandler
    public void onMatchGetMinPlayers(PlayerJoinEvent event)
    {
        Collection<? extends Player> jogadores = Bukkit.getOnlinePlayers(); // online players at the moment
        int numPlayers = jogadores.size(); // number of players
        Bukkit.broadcast(Component.text("Faltam " + (10 - numPlayers) + " jogadores para começar")); // players remaining to start

        // if we have 10 or more players, match will start
        if (numPlayers >= 10) {
            @NotNull Plugin plugin = Hgplugin.getInstance();

            // match start countdown
            new BukkitRunnable() {
                int countdown = 30; // initial time in seconds

                @Override
                public void run() {

                    if (countdown == 30 || countdown == 15 || countdown == 5 || countdown == 4 || countdown == 3 || countdown == 2 || countdown == 1) {
                        Bukkit.broadcast(Component.text("§eFaltam " + countdown + " segundos para o início da partida!"));
                    }

                    if (countdown == 0) {
                        Bukkit.broadcast(Component.text("§aA partida começou!"));
                        StartMatch.execute(); // calling method to start match
                        cancel();
                        return;
                    }
                    Bukkit.broadcast(Component.text("§ePartida começando em " + countdown + " segundos..."));
                    countdown--;
                }
            }.runTaskTimer(plugin, 0L, 20L); // 20 ticks = 1 segundo
        }
    }
    
    

}
