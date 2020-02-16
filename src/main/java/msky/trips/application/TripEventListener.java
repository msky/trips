package msky.trips.application;

import lombok.RequiredArgsConstructor;
import msky.trips.domain.DurationOfTripChanged;
import msky.trips.domain.NewAttractionAddedEvent;
import msky.trips.domain.TripCreated;
import msky.trips.query.*;

@RequiredArgsConstructor
public class TripEventListener {

    private final TripOverviewRepository overviewRepository;
    private final TripDetailsRepository detailsRepository;

    public void handle(TripCreated event) {
        overviewRepository.insert(new TripOverviewProjection(event.ownerId(), event.tripGUID(), event.tripName()));
        detailsRepository.insert(new TripDetailsProjection(event.ownerId(), event.tripGUID(), event.tripName()));
    }

    public void handle(DurationOfTripChanged event) {
        TripDetailsProjection tripDetails = detailsRepository.load(event.tripGUID());
        TripDetailsProjection updatedDetails = tripDetails.toBuilder()
                .startDate(event.startDate())
                .endDate(event.endDate())
                .build();
        detailsRepository.update(updatedDetails);
    }

    public void handle(NewAttractionAddedEvent event) {
        TripDetailsProjection tripDetails = detailsRepository.load(event.tripGUID());
        TripDetailsProjection updatedDetails = tripDetails.toBuilder().wantToSeeAttraction(new AttractionProjection(
                event.attractionGUID(),
                event.name(),
                event.latCoordinate(),
                event.longCoordinate(),
                event.estimatedArrivalTime(),
                event.estimatedHoursSpent()))
                .build();
        detailsRepository.update(updatedDetails);
    }
}
