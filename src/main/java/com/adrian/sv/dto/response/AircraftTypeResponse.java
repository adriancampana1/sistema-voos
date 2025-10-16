package com.adrian.sv.dto.response;

import com.adrian.sv.model.entity.Aeronave;
import com.adrian.sv.model.entity.Voo;

import java.time.LocalDateTime;
import java.util.List;

public record AircraftTypeResponse(
        Long id,
        String type,
        String description,
        Short passengerCapacity,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<Aeronave> aircraft,
        List<Voo> voos
) {
}
