package msky.trips.application;

import msky.trips.domain.Event;
import msky.trips.domain.Trip;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTripRepository implements TripRepository {

    private List<Event> events = new ArrayList<>();

    @Override
    public void save(Trip trip) {
        events.addAll(trip.getUncommittedEvents());
    }
}
