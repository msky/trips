package msky.trips.query;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TripQueryHandler {

    private final TripOverviewRepository overviewRepository;
    private final TripDetailsRepository detailsRepository;

    public TripOverviewProjection handle(ReadTripQuery query) {
        return overviewRepository.getOverviewFor(query.tripGUID());
    }

    public TripDetailsProjection handle(ReadTripDetailsQuery query) {
        return detailsRepository.load(query.tripGUID());
    }
}
