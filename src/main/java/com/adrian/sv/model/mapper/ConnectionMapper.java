package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.connection.CreateConnectionRequest;
import com.adrian.sv.dto.request.connection.UpdateConnectionRequest;
import com.adrian.sv.dto.response.ConnectionResponse;
import com.adrian.sv.model.entity.EscalaVoo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ConnectionMapper {
    EscalaVoo toEntity(CreateConnectionRequest request);
    ConnectionResponse toResponseDTO(EscalaVoo connection);
    void updateEntity(UpdateConnectionRequest request, @MappingTarget EscalaVoo connection);
}
