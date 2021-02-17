package br.com.quantum.eventsplus.commands.admin;

import br.com.quantum.eventsplus.core.EventRunning;
import br.com.quantum.eventsplus.core.EventsPlus;
import br.com.quantum.eventsplus.data.PluginData;
import br.com.quantum.eventsplus.entity.CommandBase;
import br.com.quantum.eventsplus.utils.Utilities;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class FinishEventConfig extends CommandBase {
    public FinishEventConfig(EventsPlus eventsPlus) {
        super(eventsPlus, "finisheventconfig");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (PluginData.event.isConfigFinish()) {
            sender.sendMessage(Utilities.formatText("&cA configuracao do evento ja foi finalizada!"));
            return;
        }


        PluginData.event.setConfigFinish(true);

        sender.sendMessage(Utilities.formatText("&aConfiguracao do evento finalizada!"));
        Bukkit.broadcastMessage(Utilities.formatText("&6&lNovo evento criado, use /events para acessar"));


        PluginData.eventRunning = new EventRunning();
    }
}
