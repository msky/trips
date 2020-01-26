package msky.trips.query;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
public class TripDetailsProjection {
    private final String ownerId;
    private final String tripGUID;
    private final String name;

    private LocalDate startDate;
    private LocalDate endDate;
}
