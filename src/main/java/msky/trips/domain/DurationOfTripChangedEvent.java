package msky.trips.domain;

import lombok.Value;

import java.time.LocalDate;

@Value
public class DurationOfTripChangedEvent implements Event {
    private final String tripGUID;
    private final LocalDate startDate;
    private final LocalDate endDate;

    @Override
    public void applyOn(Trip trip) {
        trip.apply(this);
    }
}
