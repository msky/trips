package msky.trips.domain;

public interface Event {

    String tripGUID();

    void applyOn(Trip trip);
}
