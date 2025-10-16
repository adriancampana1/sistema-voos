package com.adrian.sv.dto.request.flight;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalTime;

public record UpdateFlightRequest(
        Long idFlightType,
        Long idAircraftType,
        Long idOriginAirport,
        Long idDestinationAirport,
        LocalDate departureDate,
        LocalTime scheduledDepartureTime,
        LocalDate arrivalDate,
        LocalTime scheduledArrivalTime,
        LocalTime scheduledDurationMin,
        String status
) {
}
