package msky.trips.query;

import lombok.Value;

@Value
public class TripOverviewProjection {
    private String ownerId;
    private String tripName;
    private String tripGUID;}
