package com.adrian.sv.dto.response;

import java.time.LocalDateTime;

public record CardPaymentResponse(
        Long id,
        BookingResponse booking,
        String cardBrand,
        String encryptedCardNumber,
        Short expirationMonth,
        Short expirationYear,
        LocalDateTime authorizationDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
