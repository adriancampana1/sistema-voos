package com.adrian.sv.dto.request.ticket;

import jakarta.validation.constraints.NotBlank;

public record CreateTicketRequest(
        @NotBlank Long idBooking,
        @NotBlank String passengerName,
        @NotBlank Integer seatNumber,
        @NotBlank Boolean checkInCompleted
) {
}
