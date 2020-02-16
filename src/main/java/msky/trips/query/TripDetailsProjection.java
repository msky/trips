package msky.trips.query;


import lombok.*;

import java.time.LocalDate;
import java.util.List;

import static java.util.Collections.emptyList;

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

    @Singular
    private List<AttractionProjection> wantToSeeAttractions = emptyList();
}
