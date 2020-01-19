package msky.trips

import msky.trips.application.TripCommandHandler
import msky.trips.application.TripConfiguration
import msky.trips.domain.CreateTripCommand
import msky.trips.query.ReadTripQuery
import msky.trips.query.TripQueryHandler
import spock.lang.Specification

class CreateTripTest extends Specification {

    private TripConfiguration configuration = new TripConfiguration();
    private TripCommandHandler commandHandler = configuration.commandHandler();
    private TripQueryHandler queryHandler = configuration.queryHandler();

    def "owner can find created trip"() {
        given: "owner defines a name for a new trip"
        String ownerId = UUID.randomUUID().toString()
        String name = "Iceland 2k20"
        String tripId = UUID.randomUUID().toString()
        CreateTripCommand command = new CreateTripCommand(ownerId, name, tripId)

        when: "trip is created with defined name"
        commandHandler.handle(command)

        then: "trip can be loaded"
        ReadTripQuery query = new ReadTripQuery(tripId)
        queryHandler.handle(query).tripName == name
    }
}
