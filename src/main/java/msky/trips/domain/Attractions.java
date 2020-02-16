package msky.trips.domain;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Attractions {
    private final List<Attraction> attractions = new ArrayList<>();

    void add(Attraction attraction) {
        attractions.add(attraction);
    }
}

@AllArgsConstructor
class Attraction {
    private final String name;
    private final double latCoordinate;
    private final double longCoordinate;
    private final LocalDateTime estimatedArrivalTime;
    private final int estimatedHoursSpent;
}


