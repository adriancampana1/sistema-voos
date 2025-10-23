package com.adrian.sv.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record FlightResponse(
        Long id,
        FlightTypeResponse flightType,
        AircraftTypeSimpleResponse aircraftType,
        AirportResponse originAirport,
        AirportResponse destinationAirport,
        LocalDate departureDate,
        LocalTime scheduledDepartureTime,
        LocalDate arrivalDate,
        LocalTime scheduledArrivalTime,
        LocalTime scheduledDurationMin,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
