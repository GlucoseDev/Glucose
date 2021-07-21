package ml.glucosedev.glucose.event;

import ml.glucosedev.glucoselib.event.EventManager;

import java.util.HashMap;
import java.util.List;

public class EventManagerImpl implements EventManager {
    private List<Object> registeredEvents;

    @Override
    public void registerEvent(Object listener) {
        registeredEvents.add(listener);
    }
}
