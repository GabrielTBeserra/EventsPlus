package br.com.quantum.eventsplus.commands.admin;

import br.com.quantum.eventsplus.core.EventsPlus;
import br.com.quantum.eventsplus.data.PluginData;
import br.com.quantum.eventsplus.entity.CommandBase;
import br.com.quantum.eventsplus.utils.Utilities;
import org.bukkit.command.CommandSender;

public class SetPlayersLimit extends CommandBase {
    public SetPlayersLimit(EventsPlus eventsPlus) {
        super(eventsPlus, "setplayerslimit");
    }

    @Override
    public void execute(CommandSender sender , String[] args) {
        if (PluginData.event.isConfigFinish()) {
            sender.sendMessage(Utilities.formatText("&cA configuracao do evento ja foi finalizada!"));
            return;
        }

        int limit = 0;

        try {
            limit = Integer.parseInt(args[0]);
        } catch (Exception e) {
            sender.sendMessage(Utilities.formatText("&cUse /setplayerslimit <LIMITE>"));
            return;
        }

        PluginData.event.setPlayersLimit(limit);
        sender.sendMessage(Utilities.formatText("&aLimite de players definido com sucesso!"));
    }
}
