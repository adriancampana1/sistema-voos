package com.adrian.sv.dto.request.employeecategory;

import jakarta.validation.constraints.NotBlank;

public record CreateEmployeeCategoryRequest(
    @NotBlank String type,
    String description
) {
}
