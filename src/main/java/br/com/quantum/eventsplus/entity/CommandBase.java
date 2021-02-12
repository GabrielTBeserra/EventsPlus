package br.com.quantum.eventsplus.entity;

import br.com.quantum.eventsplus.core.EventsPlus;
import br.com.quantum.eventsplus.data.PluginData;
import br.com.quantum.eventsplus.utils.Utilities;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class CommandBase implements CommandExecutor {
    private EventsPlus eventsPlus;

    public CommandBase(EventsPlus eventsPlus , String command) {
        this.eventsPlus = eventsPlus;
        this.eventsPlus.getCommand(command).setExecutor(this);
    }

    public abstract void execute(CommandSender sender , String[] args);


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Command only for players!");
            return true;
        }

        if (PluginData.event == null) {
            sender.sendMessage(Utilities.formatText("&cNao existe nenhum evento configurado!"));
            return true;
        }

       

        execute(sender , args);


        return false;
    }
}
