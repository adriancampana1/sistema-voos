package com.adrian.sv.dto.response;

import com.adrian.sv.model.entity.Reserva;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record BoletoPaymentResponse(
        Long id,
        Reserva booking,
        String boletoCode,
        LocalDate dueDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
