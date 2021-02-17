package br.com.quantum.eventsplus.core;

import br.com.quantum.eventsplus.data.PluginData;
import br.com.quantum.eventsplus.utils.SerializeInv;
import br.com.quantum.eventsplus.utils.Utilities;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.inventivetalent.bossbar.BossBarAPI;

public class EventRunning {
    public EventRunning() {
        Bukkit.broadcastMessage(Utilities.formatText("&aEvento &9" + PluginData.event.getName() + " &ainicinado!"));
    }

    public void load() {
        PluginData.event.setAvaliable(false);

        for (Player p : PluginData.event.getPlayers()) {
            String itens = SerializeInv.itemStackArrayToBase64(p.getInventory().getContents());
            SerializeInv.save(EventsPlus.getInstance(), itens, p);

            p.getInventory().clear();
            p.teleport(PluginData.event.getWaitPoint());

        }

    }

    public void start() {
        for (Player p : PluginData.event.getPlayers()) {
            BossBarAPI.addBar(p,
                    new TextComponent("Tempo restante!"),
                    BossBarAPI.Color.BLUE,
                    BossBarAPI.Style.NOTCHED_20,
                    1.0f,
                    20,
                    2);
        }
    }

    public void end() {
        for (Player p : PluginData.event.getPlayers()) {
            p.getInventory().clear();
            String itens = SerializeInv.recovery(EventsPlus.getInstance(), p);
            try {
                ItemStack[] itemStacks = SerializeInv.itemStackArrayFromBase64(itens);

                p.getInventory().setContents(itemStacks);
            } catch (Exception ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
