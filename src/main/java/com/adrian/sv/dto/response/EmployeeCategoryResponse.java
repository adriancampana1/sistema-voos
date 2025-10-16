package com.adrian.sv.dto.response;

import java.time.LocalDateTime;

public record EmployeeCategoryResponse(
        Long id,
        String type,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
