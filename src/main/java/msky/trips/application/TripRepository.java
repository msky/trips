package msky.trips.application;

import msky.trips.domain.Trip;

public interface TripRepository {

    void save(Trip trip);

    Trip load(String tripGUID);
}
