package msky.trips.domain;

import msky.trips.application.Aggregate;

public class Trip extends Aggregate {
    private String ownerId;
    private String tripName;
    private String tripGUID;

    private Attractions wantToSeeAttractions = new Attractions();
    private Duration duration = new Duration();

    public void apply(TripCreatedEvent event) {
        this.ownerId = event.ownerId();
        this.tripName = event.tripName();
        this.tripGUID = event.tripGUID();

        this.register(event);
    }

    public void apply(DurationOfTripChangedEvent durationOfTripChanged) {
        duration.changeTo(durationOfTripChanged.startDate(), durationOfTripChanged.endDate());

        this.register(durationOfTripChanged);
    }

    public void apply(NewAttractionAddedEvent newAttractionAddedEvent) {
        wantToSeeAttractions.add(new Attraction(newAttractionAddedEvent.name(),
                newAttractionAddedEvent.latCoordinate(),
                newAttractionAddedEvent.longCoordinate(),
                newAttractionAddedEvent.estimatedArrivalTime(),
                newAttractionAddedEvent.estimatedHoursSpent()));

        this.register(newAttractionAddedEvent);
    }
}
