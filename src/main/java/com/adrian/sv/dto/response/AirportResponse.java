package com.adrian.sv.dto.response;

import java.time.LocalDateTime;

public record AirportResponse(
        Long id,
        String code,
        String name,
        String city,
        String state,
        String country,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
