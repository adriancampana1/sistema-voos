package com.adrian.sv.dto.request.connection;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreateConnectionRequest(
        @NotBlank Long idFlight,
        @NotBlank Long idAirport,
        @NotBlank Integer stopOrder,
        @NotBlank LocalDate departureDate,
        @NotBlank LocalTime scheduledDepartureTime,
        @NotBlank LocalDate arrivalDate,
        @NotBlank LocalTime scheduledArrivalTime
        ) {
}
