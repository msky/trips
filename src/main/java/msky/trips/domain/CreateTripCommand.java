package msky.trips.domain;

import lombok.Value;

@Value
public class CreateTripCommand {
    private String ownerId;
    private String tripName;
    private String tripGUID;
}
