package com.adrian.sv.dto.request.flight;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreateFlightRequest(
        @NotBlank Long idFlightType,
        @NotBlank Long idAircraftType,
        @NotBlank Long idOriginAirport,
        @NotBlank Long idDestinationAirport,
        @NotBlank LocalDate departureDate,
        @NotBlank LocalTime scheduledDepartureTime,
        @NotBlank LocalDate arrivalDate,
        @NotBlank LocalTime scheduledArrivalTime,
        @NotBlank LocalTime scheduledDurationMin,
        String status
        ) {
}
