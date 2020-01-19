package msky.trips.application;

import msky.trips.query.TripQueryHandler;

public class TripConfiguration {

    private final InMemoryTripProjectionsRepository inMemoryProjections = new InMemoryTripProjectionsRepository();

    public TripCommandHandler commandHandler() {
        return new TripCommandHandler(new SyncEventsPublisher(new TripEventListener(inMemoryProjections)),
                new InMemoryTripRepository());
    }

    public TripQueryHandler queryHandler() {
        return new TripQueryHandler(inMemoryProjections);
    }
}
