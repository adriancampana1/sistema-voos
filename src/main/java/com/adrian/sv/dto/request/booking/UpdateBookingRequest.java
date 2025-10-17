package com.adrian.sv.dto.request.booking;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateBookingRequest(
        Long idPassenger,
        Long idFlight,
        LocalDate purchaseDate,
        BigDecimal totalAmount,
        String paymentMethod,
        String paymentStatus,
        LocalDate confirmationDate,
        LocalDate cancellationDate
) {
}
