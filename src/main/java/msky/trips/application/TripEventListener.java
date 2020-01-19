package msky.trips.application;

import lombok.RequiredArgsConstructor;
import msky.trips.domain.TripCreated;
import msky.trips.query.TripOverviewProjection;
import msky.trips.query.TripProjectionRepository;

@RequiredArgsConstructor
public class TripEventListener {

    private final TripProjectionRepository repo;

    public void handle(TripCreated event) {
        repo.insert(new TripOverviewProjection(event.ownerId(), event.tripName(), event.tripGUID()));
    }
}
