package br.com.quantum.eventsplus.commands.admin;

import br.com.quantum.eventsplus.core.EventsPlus;
import br.com.quantum.eventsplus.data.PluginData;
import br.com.quantum.eventsplus.entity.CommandBase;
import br.com.quantum.eventsplus.utils.Utilities;
import org.bukkit.command.CommandSender;

public class SetTime extends CommandBase {
    public SetTime(EventsPlus eventsPlus) {
        super(eventsPlus, "settime");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (PluginData.event.isConfigFinish()) {
            sender.sendMessage(Utilities.formatText("&cA configuracao do evento ja foi finalizada!"));
            return;
        }


        int time = 0;

        try {
            time = Integer.parseInt(args[0]);
        } catch (Exception e) {
            sender.sendMessage(Utilities.formatText("&cUse /settime <TIME>"));
            return;
        }


        PluginData.event.setTime(time);
        sender.sendMessage(Utilities.formatText("&aTempo configurado com sucesso!"));

    }
}
