package msky.trips.query;

import lombok.Value;

@Value
public class ReadTripDetailsQuery {
    private final String tripGUID;
}
