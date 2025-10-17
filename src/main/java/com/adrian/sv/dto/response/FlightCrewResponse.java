package com.adrian.sv.dto.response;

import com.adrian.sv.model.entity.Funcionario;
import com.adrian.sv.model.entity.Voo;

import java.time.LocalDateTime;

public record FlightCrewResponse(
        Long id,
        Voo flight,
        Funcionario employee,
        String role,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
