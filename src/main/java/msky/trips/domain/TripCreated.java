package msky.trips.domain;

import lombok.Value;

@Value
public class TripCreated implements Event {
    private String ownerId;
    private String tripName;
    private String tripGUID;

    @Override
    public void applyOn(Trip trip) {
        trip.apply(this);
    }
}
