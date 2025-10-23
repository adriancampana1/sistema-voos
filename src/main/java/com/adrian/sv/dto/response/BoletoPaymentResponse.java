package com.adrian.sv.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record BoletoPaymentResponse(
        Long id,
        BookingResponse booking,
        String boletoCode,
        LocalDate dueDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
