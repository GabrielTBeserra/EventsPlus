package br.com.quantum.eventsplus.events;


import br.com.quantum.eventsplus.core.EventsPlus;
import br.com.quantum.eventsplus.data.PluginData;
import br.com.quantum.eventsplus.utils.SerializeInv;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class GameListener implements Listener {
    private final EventsPlus premiumShop;

    public GameListener(EventsPlus premiumShop) {
        this.premiumShop = premiumShop;
        this.premiumShop.getServer().getPluginManager().registerEvents(this, premiumShop);
    }


    @EventHandler
    public void onQuitEvent(PlayerQuitEvent e) {
        if (PluginData.event != null) {
            if (PluginData.event.getPlayers().contains(e.getPlayer())) {
                String itens = SerializeInv.recovery(this.premiumShop, e.getPlayer());
                try {
                    ItemStack[] itemStacks = SerializeInv.itemStackArrayFromBase64(itens);

                    e.getPlayer().getInventory().setContents(itemStacks);
                } catch (Exception ioException) {
                    ioException.printStackTrace();
                }
            }

            PluginData.event.getPlayers().remove(e.getPlayer());
        }
    }

    @EventHandler
    public void onDie(PlayerDeathEvent event) {
        if (PluginData.event != null) {
            if (PluginData.event.getPlayers().contains(event.getEntity())) {
                String itens = SerializeInv.recovery(this.premiumShop, event.getEntity());
                try {
                    ItemStack[] itemStacks = SerializeInv.itemStackArrayFromBase64(itens);

                    event.getEntity().getInventory().setContents(itemStacks);
                } catch (Exception ioException) {
                    ioException.printStackTrace();
                }
            }

            PluginData.event.getPlayers().remove(event.getEntity());

            if (PluginData.event.getPlayers().size() == 1) {
                PluginData.eventRunning.end();
            }
        }

    }
}
