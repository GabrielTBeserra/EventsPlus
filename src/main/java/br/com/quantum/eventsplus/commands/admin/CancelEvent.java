package br.com.quantum.eventsplus.commands.admin;

import br.com.quantum.eventsplus.core.EventsPlus;
import br.com.quantum.eventsplus.data.PluginData;
import br.com.quantum.eventsplus.utils.Utilities;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CancelEvent implements CommandExecutor {
    private final EventsPlus plugin;

    public CancelEvent(EventsPlus plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("cancelevent").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Command only for players!");
            return true;
        }


        if (PluginData.event == null) {
            sender.sendMessage(Utilities.formatText("&cNao existe um evento configurado"));
            return true;
        }

        PluginData.event = null;

        return true;
    }
}
