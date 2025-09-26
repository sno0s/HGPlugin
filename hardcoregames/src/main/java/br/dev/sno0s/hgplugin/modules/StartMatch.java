package br.dev.sno0s.hgplugin.modules;

import br.dev.sno0s.hgplugin.Hgplugin;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;

public class StartMatch {

    /*
        if all players are set in, the match will start
        - clean inventory
        - set gamemode survival
        - set kit items
        - set 1 min 45 sec invencibility
     */


    public static void execute() {
        Collection<? extends Player> jogadores = Bukkit.getOnlinePlayers();
        Plugin plugin = Hgplugin.getInstance();

        // players initial configs, in invincibility
        for (Player p : jogadores) {
            p.setInvulnerable(true);
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().clear();
            /*
                TODO: Here, call a method that will set all players kit items
             */
        }

        // invincibility countdown
        new BukkitRunnable() {
            int countdown = 105; // 1m45s

            @Override
            public void run() {
                if (countdown == 105 || countdown == 30 || countdown == 15
                        || (countdown <= 5 && countdown > 0)) {
                    Bukkit.broadcast(Component.text("§eFaltam " + countdown + " segundos de invencibilidade."));
                }

                if (countdown == 0) {
                    Bukkit.broadcast(Component.text("§aA invencibilidade acabou!"));

                    for (Player p : Bukkit.getOnlinePlayers()) {
                        p.setInvulnerable(false);

                    }
                    cancel(); // Para o contador
                    return;
                }

                countdown--; // decrementa a cada segundo
            }
        }.runTaskTimer(plugin, 0L, 20L); // 20 ticks = 1 segundo
    }
}
