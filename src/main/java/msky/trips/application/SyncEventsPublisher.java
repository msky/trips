package msky.trips.application;

import lombok.RequiredArgsConstructor;
import msky.trips.domain.DurationOfTripChanged;
import msky.trips.domain.Event;
import msky.trips.domain.NewAttractionAddedEvent;
import msky.trips.domain.TripCreated;

@RequiredArgsConstructor
public class SyncEventsPublisher implements EventsPublisher {

    private final TripEventListener tripEventListener;

    @Override // TODO any ideas of different implementation ?
    public void publish(Event event) {
        if (event instanceof TripCreated) {
            tripEventListener.handle((TripCreated) event);
        } else if (event instanceof DurationOfTripChanged) {
            tripEventListener.handle((DurationOfTripChanged) event);
        } else if (event instanceof NewAttractionAddedEvent) {
            tripEventListener.handle((NewAttractionAddedEvent) event);
        }
    }

}
