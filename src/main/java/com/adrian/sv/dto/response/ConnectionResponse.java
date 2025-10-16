package com.adrian.sv.dto.response;

import com.adrian.sv.model.entity.Aeroporto;
import com.adrian.sv.model.entity.Voo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record ConnectionResponse(
        Long id,
        Voo flight,
        Aeroporto airport,
        Integer stopOrder,
        LocalDate departureDate,
        LocalTime scheduledDepartureTime,
        LocalDate arrivalDate,
        LocalTime scheduledArrivalTime,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
