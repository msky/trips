package msky.trips.application;

import lombok.RequiredArgsConstructor;
import msky.trips.domain.CreateTripCommand;
import msky.trips.domain.Trip;
import msky.trips.domain.TripCreated;

@RequiredArgsConstructor
public class TripCommandHandler {

    private final EventsPublisher events;

    private final TripRepository repository;

    public void handle(CreateTripCommand createTripCommand) {
        Trip newTrip = new Trip();
        TripCreated tripCreated = new TripCreated(createTripCommand.ownerId(), createTripCommand.tripName(), createTripCommand.tripGUID());
        newTrip.apply(tripCreated);
        repository.save(newTrip);

        events.publish(tripCreated);
    }
}
