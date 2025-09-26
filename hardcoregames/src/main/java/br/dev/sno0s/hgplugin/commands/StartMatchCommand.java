package br.dev.sno0s.hgplugin.commands;

import br.dev.sno0s.hgplugin.modules.StartMatch;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartMatchCommand implements CommandExecutor {

    /*
        CommandExecutor to force the match start
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // verify if sender is a player
        if (!(sender instanceof Player)) {
            sender.sendMessage("Iniciando a partida");
            StartMatch.execute();
            return true;
        }

        Player player = (Player) sender;

        // execute match start and say it to the console
        player.sendMessage(Component.text("§aVocê iniciou a partida!"));
        sender.sendMessage(player.getName() + " iniciou a partida.");
        StartMatch.execute();

        return true;
    }
}
