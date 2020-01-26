package msky.trips.domain;

import msky.trips.application.Aggregate;

import java.time.LocalDate;

public class Trip extends Aggregate {
    private String ownerId;
    private String tripName;
    private String tripGUID;

    private Duration duration = new Duration();

    public void apply(TripCreated event) {
        this.ownerId = event.ownerId();
        this.tripName = event.tripName();
        this.tripGUID = event.tripGUID();

        this.register(event);
    }

    public void apply(DurationOfTripChanged durationOfTripChanged) {
        duration.changeTo(durationOfTripChanged.startDate(), durationOfTripChanged.endDate());

        this.register(durationOfTripChanged);
    }
}
