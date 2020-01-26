package msky.trips.domain;

import java.time.LocalDate;

// TODO rename
public class Duration {
    private LocalDate startDate;
    private LocalDate endDate;

    public void changeTo(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
