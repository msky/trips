package msky.trips.domain;

import lombok.Value;

import java.time.LocalDate;

@Value
public class ChangeTripDurationCommand {
    private final String tripGUID;
    private final LocalDate startDate;
    private final LocalDate endDate;
}
