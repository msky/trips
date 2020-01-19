package msky.trips.application;

import msky.trips.domain.Event;

import java.util.ArrayList;
import java.util.List;

public abstract class Aggregate {

    private final List<Event> uncommittedEvents = new ArrayList<>();

    //TODO check if reloading state
    protected void register(Event event) {
        uncommittedEvents.add(event);
    }

    public List<Event> getUncommittedEvents() {
        return List.copyOf(uncommittedEvents);
    }
}
