package br.com.quantum.eventsplus.commands.admin;

import br.com.quantum.eventsplus.core.EventsPlus;
import br.com.quantum.eventsplus.data.PluginData;
import br.com.quantum.eventsplus.entity.CommandBase;
import br.com.quantum.eventsplus.utils.Utilities;
import org.bukkit.command.CommandSender;

public class EndEvent extends CommandBase {
    public EndEvent(EventsPlus eventsPlus) {
        super(eventsPlus, "endevent");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!PluginData.event.isConfigFinish()) {
            sender.sendMessage(Utilities.formatText("&cA configuracao do evento precisa ser finalizada!"));
            return;
        }

        PluginData.eventRunning.end();
    }
}
