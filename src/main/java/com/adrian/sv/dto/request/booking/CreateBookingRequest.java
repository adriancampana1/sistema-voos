package com.adrian.sv.dto.request.booking;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateBookingRequest(
        @NotBlank Long idPassenger,
        @NotBlank Long idFlight,
        String bookingNumber,
        @NotBlank LocalDate purchaseDate,
        @NotBlank BigDecimal totalAmount,
        @NotBlank String paymentMethod,
        String paymentStatus,
        LocalDate confirmationDate,
        LocalDate cancellationDate
) {
}
