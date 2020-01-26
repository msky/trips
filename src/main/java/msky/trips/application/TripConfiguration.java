package msky.trips.application;

import msky.trips.query.TripDetailsRepository;
import msky.trips.query.TripOverviewRepository;
import msky.trips.query.TripQueryHandler;

public class TripConfiguration {

    private final TripOverviewRepository inMemoryTripOverviewsRepository = new InMemoryTripOverviewRepository();
    private final TripDetailsRepository inMemoryTripDetailsRepository = new InMemoryTripDetailsRepository();
    private final TripRepository inMemoryTripEventRepository = new InMemoryTripRepository();

    public TripCommandHandler commandHandler() {
        return new TripCommandHandler(new SyncEventsPublisher(
                new TripEventListener(inMemoryTripOverviewsRepository, inMemoryTripDetailsRepository)),
                inMemoryTripEventRepository);
    }

    public TripQueryHandler queryHandler() {
        return new TripQueryHandler(inMemoryTripOverviewsRepository, inMemoryTripDetailsRepository);
    }
}
