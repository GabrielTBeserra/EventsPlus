package br.com.quantum.eventsplus.data;

import br.com.quantum.eventsplus.core.EventRunning;
import br.com.quantum.eventsplus.entity.GameEvent;

public class PluginData {
    public static EventRunning eventRunning;
    public static GameEvent event;

    static {
        event = null;
        eventRunning = null;
    }


}
