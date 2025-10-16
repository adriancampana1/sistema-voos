package com.adrian.sv.dto.response;

import com.adrian.sv.model.entity.Aeroporto;
import com.adrian.sv.model.entity.TipoAeronave;
import com.adrian.sv.model.entity.TipoVoo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record FlightResponse(
        Long id,
        TipoVoo flightType,
        TipoAeronave aircraftType,
        Aeroporto originAirport,
        Aeroporto destinationAirport,
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
