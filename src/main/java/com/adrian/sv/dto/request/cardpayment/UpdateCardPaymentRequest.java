package com.adrian.sv.dto.request.cardpayment;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record UpdateCardPaymentRequest(
        Long idBooking,
        String cardBrand,
        String encryptedCardNumber,
        Short expirationMonth,
        Short expirationYear,
        LocalDateTime authorizationDate
) {
}
