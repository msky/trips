package msky.trips.query;

public interface TripDetailsRepository {
    void insert(TripDetailsProjection details);

    TripDetailsProjection load(String tripGUID);

    void update(TripDetailsProjection details);
}
