package msky.trips.domain;

public interface Event {
    void applyOn(Trip trip);
}
