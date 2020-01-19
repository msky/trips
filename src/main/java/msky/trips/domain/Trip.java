package msky.trips.domain;

import msky.trips.application.Aggregate;

public class Trip extends Aggregate {
    private String ownerId;
    private String tripName;
    private String tripGUID;

    public void apply(TripCreated event) {
        this.ownerId = event.ownerId();
        this.tripName = event.tripName();
        this.tripGUID = event.tripGUID();

        this.register(event);
    }
}
