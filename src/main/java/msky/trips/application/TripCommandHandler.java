package msky.trips.application;

import lombok.RequiredArgsConstructor;
import msky.trips.domain.*;

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

    public void handle(ChangeTripDurationCommand command) {
        Trip trip = repository.load(command.tripGUID());
        trip.apply(new DurationOfTripChanged(command.tripGUID(), command.startDate(), command.endDate()));

        repository.save(trip);
        trip.getUncommittedEvents().forEach(events::publish);
    }
}
