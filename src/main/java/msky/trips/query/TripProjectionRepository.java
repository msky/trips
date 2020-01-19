package msky.trips.query;

public interface TripProjectionRepository {
    void insert(TripOverviewProjection newTripOverview);

    TripOverviewProjection getOverviewFor(String tripGUID);
}
