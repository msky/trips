package msky.trips.application;

import lombok.RequiredArgsConstructor;
import msky.trips.domain.Event;
import msky.trips.domain.TripCreated;

@RequiredArgsConstructor
public class SyncEventsPublisher implements EventsPublisher {

    private final TripEventListener tripEventListener;

    @Override // TODO ?
    public void publish(Event event) {
        if (event instanceof TripCreated) {
            tripEventListener.handle((TripCreated) event);
        }
    }
    
}
