package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.boletopayment.CreateBoletoPaymentRequest;
import com.adrian.sv.dto.request.boletopayment.UpdateBoletoPaymentRequest;
import com.adrian.sv.dto.response.BoletoPaymentResponse;
import com.adrian.sv.model.entity.PagamentoBoleto;
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
public abstract class BoletoPaymentMapper {

    @Autowired
    protected BookingRepository bookingRepository;

    @Autowired
    protected BookingMapper bookingMapper;

    @Mapping(source = "idBooking", target = "reserva", qualifiedByName = "mapBooking")
    public abstract PagamentoBoleto toEntity(CreateBoletoPaymentRequest request);

    public BoletoPaymentResponse toResponseDTO(PagamentoBoleto boletoPayment) {
        if (boletoPayment == null) {
            return null;
        }
        return new BoletoPaymentResponse(
                boletoPayment.getId(),
                bookingMapper.toResponseDTO(boletoPayment.getReserva()),
                boletoPayment.getBoletoCode(),
                boletoPayment.getDueDate(),
                boletoPayment.getCreatedAt(),
                boletoPayment.getUpdatedAt()
        );
    }

    @Mapping(source = "idBooking", target = "reserva", qualifiedByName = "mapBooking")
    public abstract void updateEntity(UpdateBoletoPaymentRequest request, @MappingTarget PagamentoBoleto boletoPayment);

    @Named("mapBooking")
    protected Reserva mapBooking(Long idBooking) {
        if (idBooking == null) {
            return null;
        }
        return bookingRepository.findById(idBooking).orElse(null);
    }
}
