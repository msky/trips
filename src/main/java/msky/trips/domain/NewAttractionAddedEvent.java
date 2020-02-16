package msky.trips.domain;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class NewAttractionAddedEvent implements Event {
    private final String tripGUID;
    private final String attractionGUID;
    private final String name;
    private final double latCoordinate;
    private final double longCoordinate;
    private final LocalDateTime estimatedArrivalTime;
    private final int estimatedHoursSpent;

    @Override
    public void applyOn(Trip trip) {
        trip.apply(this);
    }
}
