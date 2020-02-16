package msky.trips.domain;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class AddNewAttractionCommand {
    private final String tripGUID;
    private final String attractionGUID;
    private final String name;
    private final double latCoordinate;
    private final double longCoordinate;
    private final LocalDateTime estimatedArrivalTime;
    private final int estimatedHoursSpent;
}
