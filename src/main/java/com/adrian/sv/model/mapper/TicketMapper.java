package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.ticket.CreateTicketRequest;
import com.adrian.sv.dto.request.ticket.UpdateTicketRequest;
import com.adrian.sv.dto.response.TicketResponse;
import com.adrian.sv.model.entity.Passagem;
import com.adrian.sv.model.entity.Reserva;
import com.adrian.sv.repository.BookingRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public abstract class TicketMapper {

    @Autowired
    protected BookingRepository bookingRepository;

    @Autowired
    protected BookingMapper bookingMapper;

    @Mapping(source = "idBooking", target = "reserva", qualifiedByName = "mapReserva")
    public abstract Passagem toEntity(CreateTicketRequest request);

    public TicketResponse toResponseDTO(Passagem ticket) {
        if (ticket == null) {
            return null;
        }
        return new TicketResponse(
                ticket.getId(),
                bookingMapper.toResponseDTO(ticket.getReserva()),
                ticket.getPassengerName(),
                ticket.getSeatNumber(),
                ticket.getCheckInCompleted(),
                ticket.getCreatedAt(),
                ticket.getUpdatedAt()
        );
    }

    public abstract void updateEntity(UpdateTicketRequest request, @MappingTarget Passagem ticket);

    @Named("mapReserva")
    protected Reserva mapReserva(Long idBooking) {
        if (idBooking == null) {
            return null;
        }
        return bookingRepository.findById(idBooking).orElse(null);
    }
}
