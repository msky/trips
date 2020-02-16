package msky.trips.query;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class AttractionProjection {
    private final String id;
    private final String name;
    private final double latCoordinate;
    private final double longCoordinate;
    private final LocalDateTime estimatedArrivalTime;
    private final int estimatedHoursSpent;
}
