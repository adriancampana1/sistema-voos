package com.adrian.sv.dto.response;

import com.adrian.sv.model.entity.Reserva;

import java.time.LocalDateTime;

public record TicketResponse(
        Long id,
        Reserva booking,
        String passengerName,
        Integer seatNumber,
        Boolean checkInCompleted,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
