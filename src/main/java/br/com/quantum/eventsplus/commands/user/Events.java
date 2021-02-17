package br.com.quantum.eventsplus.commands.user;

import br.com.quantum.eventsplus.core.EventsPlus;
import br.com.quantum.eventsplus.data.PluginData;
import br.com.quantum.eventsplus.entity.CommandBase;
import br.com.quantum.eventsplus.entity.menus.EventsMenu;
import br.com.quantum.eventsplus.utils.Utilities;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Events extends CommandBase {


    public Events(EventsPlus plugin) {
        super(plugin, "events");
    }


    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!PluginData.event.isConfigFinish()) {
            sender.sendMessage(Utilities.formatText("&cNao existe nenhum evento configurado!"));
            return;
        }

        if (!PluginData.event.isAvaliable()) {
            sender.sendMessage(Utilities.formatText("&cO evento ja iniciou!"));
            return;
        }

        if (PluginData.event.getPlayersLimit() != 0) {
            if (PluginData.event.getPlayersLimit() > (PluginData.event.getPlayers().size() + 1)) {
                sender.sendMessage(Utilities.formatText("&cLimite de players do evento atingido!"));
                return;
            }
        }


        Player player = (Player) sender;
        EventsMenu eventsMenu = new EventsMenu(player);
        eventsMenu.open();
    }
}
