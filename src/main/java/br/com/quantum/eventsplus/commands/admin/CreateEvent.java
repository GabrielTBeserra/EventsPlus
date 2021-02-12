package br.com.quantum.eventsplus.commands.admin;

import br.com.quantum.eventsplus.core.EventsPlus;
import br.com.quantum.eventsplus.data.PluginData;
import br.com.quantum.eventsplus.entity.GameEvent;
import br.com.quantum.eventsplus.utils.Utilities;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateEvent implements CommandExecutor {
    private final EventsPlus plugin;

    public CreateEvent(EventsPlus plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("createevent").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Command only for players!");
            return true;
        }


        String name = String.join(" ", args);


        if (PluginData.event != null) {
            sender.sendMessage(Utilities.formatText("&cJa existe um evento configurado use &a/cancelevent &cpara excluir o evento"));
            return true;
        }


        PluginData.event = new GameEvent(name);


        return true;
    }
}
