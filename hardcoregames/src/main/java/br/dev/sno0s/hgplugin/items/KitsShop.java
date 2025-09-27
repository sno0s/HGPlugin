package br.dev.sno0s.hgplugin.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class KitsShop {

    private static final Material ITEM_MATERIAL = Material.EMERALD;
    private static final String DISPLAY_NAME = "§aLoja de kits";
    private static final List<String> LORE = List.of("§7Selecione um kit para comprar!");

    /*
        create the shop item
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
}
