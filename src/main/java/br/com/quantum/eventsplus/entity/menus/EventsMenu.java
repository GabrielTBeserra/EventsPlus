package br.com.quantum.eventsplus.entity.menus;

import br.com.quantum.eventsplus.data.PluginData;
import br.com.quantum.eventsplus.entity.GameEvent;
import br.com.quantum.eventsplus.entity.Menu;
import br.com.quantum.eventsplus.utils.Utilities;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EventsMenu extends Menu {
    private final Player player;

    public EventsMenu(Player player) {
        super(27, Utilities.formatText("&aEventos Ativos"));
        this.player = player;


        Inventory inv = getInventory();

        GameEvent gameEvent = PluginData.event;
        String eventName = PluginData.event.getName();

        ItemStack itemStack = makeItem(Material.ENCHANTMENT_TABLE
                , Utilities.formatText(eventName)
                , Utilities.formatText(gameEvent.isAvaliable() ? "&aEvento Aberto" : "&cEvento Fechado"));

        inv.setItem(13, itemStack);

    }


    public void open() {
        this.player.openInventory(getInventory());
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {


        ConfirmJoin confirmJoin = new ConfirmJoin(this.player);
        confirmJoin.open();
    }
}
