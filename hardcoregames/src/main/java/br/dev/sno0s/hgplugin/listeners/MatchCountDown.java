package br.dev.sno0s.hgplugin.listeners;

import br.dev.sno0s.hgplugin.Hgplugin;
import br.dev.sno0s.hgplugin.utils.StartMatch;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Set;

import static br.dev.sno0s.hgplugin.Hgplugin.getServerName;

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
        Bukkit.broadcastMessage(getServerName() + " §eFaltam §c" + (10 - numPlayers) + " §ejogadores para começar!");


        if (numPlayers >= 10) {
            @NotNull Plugin plugin = Hgplugin.getInstance();
            Bukkit.broadcastMessage(getServerName() + " §eIniciando contagem para iniciar a partida");
            // match start countdown
            new BukkitRunnable() {
                int countdown = 30; // initial time in seconds
                @Override
                public void run() {

                    if (Set.of(30, 15, 5, 4, 3, 2, 1).contains(countdown)) {
                        Bukkit.broadcastMessage(getServerName() + " §ePartida começando em " + countdown + " §esegundos");
                    }

                    if (countdown == 0) {
                        Bukkit.broadcastMessage(getServerName() + " §aA partida começou!");

                        for (Player p : Bukkit.getOnlinePlayers()) {
                            p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH, 0.5f, 0.8f);
                        }

                        StartMatch.execute(); // calling method to start match
                        cancel();
                        return;
                    }
                    countdown--;
                }
            }.runTaskTimer(plugin, 0L, 20L); // 20 ticks = 1 segundo
        }
    }
    
    

}
