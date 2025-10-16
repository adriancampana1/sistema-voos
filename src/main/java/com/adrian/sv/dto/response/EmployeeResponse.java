package com.adrian.sv.dto.response;

import com.adrian.sv.model.entity.CategoriaFuncionario;

import java.time.LocalDateTime;

public record EmployeeResponse(
        Long id,
        CategoriaFuncionario employeeCategory,
        String name,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
