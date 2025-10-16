package com.adrian.sv.dto.request.employee;

public record UpdateEmployeeRequest(
        Long idEmployeeCategory,
        String name,
        String email
) {
}
