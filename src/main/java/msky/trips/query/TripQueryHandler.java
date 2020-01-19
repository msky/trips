package msky.trips.query;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TripQueryHandler {

    private final TripProjectionRepository repository;

    public TripOverviewProjection handle(ReadTripQuery query) {
        return repository.getOverviewFor(query.tripGUID());
    }
}
