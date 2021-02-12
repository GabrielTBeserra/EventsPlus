package br.com.quantum.eventsplus.entity.menus;

import br.com.quantum.eventsplus.data.PluginData;
import br.com.quantum.eventsplus.entity.Menu;
import br.com.quantum.eventsplus.utils.Utilities;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ConfirmJoin extends Menu {
    private final Player player;

    public ConfirmJoin(Player player) {
        super(27, Utilities.formatText("&aConfirmar participacao"));
        this.player = player;

        Inventory inv = getInventory();

        ItemStack item = new ItemStack(Material.WOOL);
        item.setDurability((short) 5);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utilities.formatText("&a&lConfirmar"));
        item.setItemMeta(meta);
        inv.setItem(11, item);

        ItemStack item2 = new ItemStack(Material.WOOL);
        item2.setDurability((short) 14);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName(Utilities.formatText("&c&lCancelar"));
        item2.setItemMeta(meta2);
        inv.setItem(15, item2);

    }

    public void open() {
        this.player.openInventory(getInventory());
    }


    @Override
    public void handleMenu(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        String striped = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());

        if (striped.equalsIgnoreCase("confirmar")) {
            PluginData.event.addPlayer(p);
        }
        p.closeInventory();
    }
}
