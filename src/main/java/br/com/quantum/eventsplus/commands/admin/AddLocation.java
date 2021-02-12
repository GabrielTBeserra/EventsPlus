package br.com.quantum.eventsplus.commands.admin;

import br.com.quantum.eventsplus.core.EventsPlus;
import br.com.quantum.eventsplus.data.PluginData;
import br.com.quantum.eventsplus.entity.CommandBase;
import br.com.quantum.eventsplus.utils.Utilities;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddLocation extends CommandBase {

    public AddLocation(EventsPlus plugin) {
        super(plugin, "addlocation");
    }


    @Override
    public void execute(CommandSender sender, String[] args) {
        if (PluginData.event.isConfigFinish()) {
            sender.sendMessage(Utilities.formatText("&cA configuracao do evento ja foi finalizada!"));
            return;
        }


        Player player = (Player) sender;
        PluginData.event.addSpawn(player.getLocation());


    }


}
