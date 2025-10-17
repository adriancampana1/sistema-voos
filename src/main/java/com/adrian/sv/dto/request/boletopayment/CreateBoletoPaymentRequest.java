package com.adrian.sv.dto.request.boletopayment;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record CreateBoletoPaymentRequest(
        @NotBlank Long idBooking,
        @NotBlank String boletoCode,
        @NotBlank LocalDate dueDate
        ) {
}
