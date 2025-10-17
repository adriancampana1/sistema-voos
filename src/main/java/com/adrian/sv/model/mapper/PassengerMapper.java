package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.passenger.CreatePassengerRequest;
import com.adrian.sv.dto.request.passenger.UpdatePassengerRequest;
import com.adrian.sv.dto.response.PassengerResponse;
import com.adrian.sv.model.entity.Passageiro;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface PassengerMapper {

    Passageiro toEntity(CreatePassengerRequest request);

    PassengerResponse toResponseDTO(Passageiro passageiro);

    void updateEntity(UpdatePassengerRequest updateRequest, @MappingTarget Passageiro passageiro);
}
