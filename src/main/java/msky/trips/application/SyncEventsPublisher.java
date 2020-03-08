package msky.trips.application;

import lombok.RequiredArgsConstructor;
import msky.trips.domain.DurationOfTripChangedEvent;
import msky.trips.domain.Event;
import msky.trips.domain.NewAttractionAddedEvent;
import msky.trips.domain.TripCreatedEvent;

@RequiredArgsConstructor
public class SyncEventsPublisher implements EventsPublisher {

    private final TripEventListener tripEventListener;

    @Override // TODO any ideas of different implementation ?
    public void publish(Event event) {
        if (event instanceof TripCreatedEvent) {
            tripEventListener.handle((TripCreatedEvent) event);
        } else if (event instanceof DurationOfTripChangedEvent) {
            tripEventListener.handle((DurationOfTripChangedEvent) event);
        } else if (event instanceof NewAttractionAddedEvent) {
            tripEventListener.handle((NewAttractionAddedEvent) event);
        }
    }

}
