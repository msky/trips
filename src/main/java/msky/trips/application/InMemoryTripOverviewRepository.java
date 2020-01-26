package msky.trips.application;

import msky.trips.query.TripOverviewProjection;
import msky.trips.query.TripOverviewRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTripOverviewRepository implements TripOverviewRepository {
    private final Map<String, TripOverviewProjection> tripsOverviews = new HashMap<>();

    @Override
    public void insert(TripOverviewProjection newTripOverview) {
        tripsOverviews.put(newTripOverview.tripGUID(), newTripOverview);
    }

    @Override
    public TripOverviewProjection getOverviewFor(String tripGUID) {
        return tripsOverviews.get(tripGUID);
    }
}
