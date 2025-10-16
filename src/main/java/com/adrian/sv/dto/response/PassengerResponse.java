package com.adrian.sv.dto.response;

import java.time.LocalDateTime;

public record PassengerResponse(
        Long id,
        String email,
        String username,
        String cpf,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
