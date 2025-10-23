package com.adrian.sv.dto.response;

import java.time.LocalDateTime;

public record FlightCrewResponse(
        Long id,
        FlightResponse flight,
        EmployeeResponse employee,
        String role,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
