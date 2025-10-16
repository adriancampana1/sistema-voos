package com.adrian.sv.dto.request.employee;

import jakarta.validation.constraints.NotBlank;

public record CreateEmployeeRequest(
    @NotBlank Long idEmployeeCategory,
    @NotBlank String name,
    @NotBlank String email
) {
}
