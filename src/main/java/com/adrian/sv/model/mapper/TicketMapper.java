package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.ticket.CreateTicketRequest;
import com.adrian.sv.dto.request.ticket.UpdateTicketRequest;
import com.adrian.sv.dto.response.TicketResponse;
import com.adrian.sv.model.entity.Passagem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface TicketMapper {
    Passagem toEntity(CreateTicketRequest request);
    TicketResponse toResponseDTO(Passagem ticket);
    void updateEntity(UpdateTicketRequest request, @MappingTarget Passagem ticket);
}
