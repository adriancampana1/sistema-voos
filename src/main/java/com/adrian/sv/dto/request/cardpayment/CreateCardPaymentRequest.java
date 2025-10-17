package com.adrian.sv.dto.request.cardpayment;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record CreateCardPaymentRequest(
        @NotBlank Long idBooking,
        @NotBlank String cardBrand,
        @NotBlank String encryptedCardNumber,
        @NotBlank Short expirationMonth,
        @NotBlank Short expirationYear,
        LocalDateTime authorizationDate
) {
}
