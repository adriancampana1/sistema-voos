package com.adrian.sv.dto.response;

import com.adrian.sv.model.entity.Passageiro;
import com.adrian.sv.model.entity.Voo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record BookingResponse(
        Long id,
        Passageiro passenger,
        Voo flight,
        LocalDate purchaseDate,
        BigDecimal totalAmount,
        String paymentMethod,
        String paymentStatus,
        LocalDate confirmationDate,
        LocalDate cancellationDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
