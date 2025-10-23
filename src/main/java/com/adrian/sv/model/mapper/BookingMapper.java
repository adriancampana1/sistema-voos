package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.booking.CreateBookingRequest;
import com.adrian.sv.dto.request.booking.UpdateBookingRequest;
import com.adrian.sv.dto.response.BookingResponse;
import com.adrian.sv.model.entity.Reserva;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public abstract class BookingMapper {

    @Autowired
    protected PassengerMapper passengerMapper;

    @Autowired
    protected FlightMapper flightMapper;

    @Mapping(target = "passageiro", ignore = true)
    @Mapping(target = "voo", ignore = true)
    public abstract Reserva toEntity(CreateBookingRequest request);

    public BookingResponse toResponseDTO(Reserva booking) {
        if (booking == null) {
            return null;
        }
        return new BookingResponse(
                booking.getId(),
                passengerMapper.toResponseDTO(booking.getPassageiro()),
                flightMapper.toResponseDTO(booking.getVoo()),
                booking.getBookingNumber(),
                booking.getPurchaseDate(),
                booking.getTotalAmount(),
                booking.getPaymentMethod(),
                booking.getPaymentStatus(),
                booking.getConfirmationDate(),
                booking.getCancellationDate(),
                booking.getCreatedAt(),
                booking.getUpdatedAt()
        );
    }

    @Mapping(target = "passageiro", ignore = true)
    @Mapping(target = "voo", ignore = true)
    public abstract void updateEntity(UpdateBookingRequest request, @MappingTarget Reserva booking);
}
