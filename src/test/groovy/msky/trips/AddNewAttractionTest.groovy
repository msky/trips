package msky.trips

import msky.trips.application.TripCommandHandler
import msky.trips.application.TripConfiguration
import msky.trips.domain.AddNewAttractionCommand
import msky.trips.domain.CreateTripCommand
import msky.trips.query.ReadTripDetailsQuery
import msky.trips.query.TripQueryHandler
import spock.lang.Specification

import java.time.LocalDateTime

class AddNewAttractionTest extends Specification {

    private TripConfiguration configuration = new TripConfiguration();
    private TripCommandHandler commandHandler = configuration.commandHandler();
    private TripQueryHandler queryHandler = configuration.queryHandler();

    def "new attraction can be added to new trip"() {
        given: "owner creates new trip"
        def ownerId = UUID.randomUUID().toString()
        def tripId = UUID.randomUUID().toString()
        def tripName = "Iceland 2020"
        commandHandler.handle(new CreateTripCommand(ownerId, tripName, tripId))

        when: "new want-to-see attraction is added to trip"
        def attractionId = UUID.randomUUID().toString()
        def name = "Very interesting sight"
        def latCoordinate = 1.0D
        def longCoordinate = 2.0D
        def estimatedArrival = LocalDateTime.of(2020, 1, 20, 10, 0)
        def estimatedHoursSpent = 2
        commandHandler.handle(new AddNewAttractionCommand(tripId, attractionId, name, latCoordinate, longCoordinate, estimatedArrival, estimatedHoursSpent))

        then: "user can see attraction added to trip"
        def trip = queryHandler.handle(new ReadTripDetailsQuery(tripId))
        trip.wantToSeeAttractions().size() == 1
        trip.wantToSeeAttractions.any({
            it.id == attractionId;
            it.name == name
            it.latCoordinate == latCoordinate
            it.longCoordinate == longCoordinate
            it.estimatedArrivalTime == estimatedArrival
            it.estimatedHoursSpent == estimatedHoursSpent
        })
    }
}
