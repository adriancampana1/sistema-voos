package com.adrian.sv.dto.response;

import java.time.LocalDateTime;

public record EmployeeResponse(
        Long id,
        EmployeeCategoryResponse employeeCategory,
        String name,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
