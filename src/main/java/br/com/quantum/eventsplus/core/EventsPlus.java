package br.com.quantum.eventsplus.core;

import br.com.quantum.eventsplus.commands.admin.CreateEvent;
import br.com.quantum.eventsplus.utils.Utilities;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class EventsPlus extends JavaPlugin {
    private static EventsPlus pl;
    public static EventsPlus getInstance(){
        return pl;
    }

    public static JavaPlugin getPlugin() {
        return pl;
    }

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(Utilities.formatText("&aPlugin Habilitado"));
        pl = this;
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(Utilities.formatText("&aPlugin Desabilitado"));
        HandlerList.unregisterAll(this);
    }

    private void loadCommands(){
        new CreateEvent(this);
    }
    private void loadEvents(){}
    private void loadConfigs(){}
}
