package msky.trips

import msky.trips.application.TripCommandHandler
import msky.trips.application.TripConfiguration
import msky.trips.domain.ChangeTripDurationCommand
import msky.trips.domain.CreateTripCommand
import msky.trips.query.ReadTripDetailsQuery
import msky.trips.query.TripQueryHandler
import spock.lang.Specification

import java.time.LocalDate

class ChangeTripDurationTest extends Specification {

    private TripConfiguration configuration = new TripConfiguration();
    private TripCommandHandler commandHandler = configuration.commandHandler();
    private TripQueryHandler queryHandler = configuration.queryHandler();

    def "owner can define start and end date of his trip"() {
        given: "owner defines a new trip and set start and end date for it"
        String ownerId = UUID.randomUUID().toString()
        String name = "Iceland 2k20"
        String tripId = UUID.randomUUID().toString()

        CreateTripCommand createNewTrip = new CreateTripCommand(ownerId, name, tripId)
        commandHandler.handle(createNewTrip)

        when: "owner changes the duration of the trip"
        LocalDate startDate = LocalDate.of(2020, 1, 1)
        LocalDate endDate = LocalDate.of(2020, 1, 10)

        ChangeTripDurationCommand changeTripDuration = new ChangeTripDurationCommand(tripId, startDate, endDate)
        commandHandler.handle(changeTripDuration)

        then: "the beginning and the end of the trip are updated"
        ReadTripDetailsQuery query = new ReadTripDetailsQuery(tripId)
        queryHandler.handle(query).startDate == startDate
        queryHandler.handle(query).endDate == endDate
    }
}