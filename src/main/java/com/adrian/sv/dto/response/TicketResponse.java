package com.adrian.sv.dto.response;

import java.time.LocalDateTime;

public record TicketResponse(
        Long id,
        BookingResponse booking,
        String passengerName,
        Integer seatNumber,
        Boolean checkInCompleted,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
