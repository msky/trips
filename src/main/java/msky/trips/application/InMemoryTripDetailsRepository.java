package msky.trips.application;

import msky.trips.query.TripDetailsProjection;
import msky.trips.query.TripDetailsRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTripDetailsRepository implements TripDetailsRepository {

    private final Map<String, TripDetailsProjection> tripsDetails = new HashMap<>();

    @Override
    public void insert(TripDetailsProjection details) {
        tripsDetails.put(details.tripGUID(), details);
    }

    @Override
    public TripDetailsProjection load(String tripGUID) {
        return tripsDetails.get(tripGUID);
    }

    @Override
    public void update(TripDetailsProjection details) {
        tripsDetails.put(details.tripGUID(), details);
    }

}
