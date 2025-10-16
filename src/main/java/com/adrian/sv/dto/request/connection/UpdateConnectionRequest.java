package com.adrian.sv.dto.request.connection;

import java.time.LocalDate;
import java.time.LocalTime;

public record UpdateConnectionRequest(
        Long idFlight,
        Long idAirport,
        Integer stopOrder,
        LocalDate departureDate,
        LocalTime scheduledDepartureTime,
        LocalDate arrivalDate,
        LocalTime scheduledArrivalTime
) {
}
