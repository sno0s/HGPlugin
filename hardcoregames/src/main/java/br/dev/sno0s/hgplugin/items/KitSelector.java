package br.dev.sno0s.hgplugin.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class KitSelector {

    private static final Material ITEM_MATERIAL = Material.CHEST;
    private static final String DISPLAY_NAME = "§eSeletor de Kits";
    private static final List<String> LORE = List.of("§7Clique para escolher seu kit!");

    /*
        Cria e retorna o item configurado do Kit Selector

        TODO: change deprecated methods
     */
    public static ItemStack create() {
        ItemStack item = new ItemStack(ITEM_MATERIAL);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(DISPLAY_NAME);
            meta.setLore(LORE);
            item.setItemMeta(meta);
        }

        return item;
    }

    private KitSelector() {}
}
