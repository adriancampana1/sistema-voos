package com.adrian.sv.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record ConnectionResponse(
        Long id,
        FlightResponse flight,
        AirportResponse airport,
        Integer stopOrder,
        LocalDate departureDate,
        LocalTime scheduledDepartureTime,
        LocalDate arrivalDate,
        LocalTime scheduledArrivalTime,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
