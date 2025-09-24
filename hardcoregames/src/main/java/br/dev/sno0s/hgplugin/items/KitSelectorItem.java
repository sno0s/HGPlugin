package br.dev.sno0s.hgplugin.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class KitSelectorItem {

    public static ItemStack create() {
        ItemStack item = new ItemStack(Material.CHEST); // pode ser ENDER_CHEST se quiser diferenciar
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§eSeletor de Kits"); // Nome colorido
        meta.setLore(Arrays.asList("§7Clique para escolher seu kit!")); // descrição opcional

        item.setItemMeta(meta);
        return item;
    }
}
