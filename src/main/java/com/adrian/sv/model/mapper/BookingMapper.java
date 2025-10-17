package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.booking.CreateBookingRequest;
import com.adrian.sv.dto.request.booking.UpdateBookingRequest;
import com.adrian.sv.dto.response.BookingResponse;
import com.adrian.sv.model.entity.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface BookingMapper {
    Reserva toEntity(CreateBookingRequest request);
    BookingResponse toResponseDTO(Reserva booking);
    void updateEntity(UpdateBookingRequest request, @MappingTarget Reserva booking);
}
