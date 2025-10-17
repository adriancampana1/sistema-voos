package com.adrian.sv.dto.request.ticket;

public record UpdateTicketRequest(
        Long idBooking,
        String passengerName,
        Integer seatNumber,
        Boolean checkInCompleted
) {
}
