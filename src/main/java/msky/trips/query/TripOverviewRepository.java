package msky.trips.query;

public interface TripOverviewRepository {
    void insert(TripOverviewProjection newTripOverview);

    TripOverviewProjection getOverviewFor(String tripGUID);
}
