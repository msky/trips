package msky.trips.application;

import msky.trips.query.TripOverviewProjection;
import msky.trips.query.TripProjectionRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTripProjectionsRepository implements TripProjectionRepository {
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
