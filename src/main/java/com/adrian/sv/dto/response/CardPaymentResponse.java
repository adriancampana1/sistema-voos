package com.adrian.sv.dto.response;

import com.adrian.sv.model.entity.Reserva;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record CardPaymentResponse(
        Long id,
        Reserva booking,
        String cardBrand,
        String encryptedCardNumber,
        Short expirationMonth,
        Short expirationYear,
        LocalDateTime authorizationDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
