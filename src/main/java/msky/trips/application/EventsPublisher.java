package msky.trips.application;

import msky.trips.domain.Event;

public interface EventsPublisher {
    void publish(Event event);
}
