package com.adrian.sv.dto.request.boletopayment;

import java.time.LocalDate;

public record UpdateBoletoPaymentRequest(
        Long idBooking,
        String boletoCode,
        LocalDate dueDate
) {
}
