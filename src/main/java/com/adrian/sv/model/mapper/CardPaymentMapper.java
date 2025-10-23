package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.cardpayment.CreateCardPaymentRequest;
import com.adrian.sv.dto.request.cardpayment.UpdateCardPaymentRequest;
import com.adrian.sv.dto.response.CardPaymentResponse;
import com.adrian.sv.model.entity.PagamentoCartao;
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
public abstract class CardPaymentMapper {

    @Autowired
    protected BookingRepository bookingRepository;

    @Autowired
    protected BookingMapper bookingMapper;

    @Mapping(source = "idBooking", target = "reserva", qualifiedByName = "mapBooking")
    public abstract PagamentoCartao toEntity(CreateCardPaymentRequest request);

    public CardPaymentResponse toResponseDTO(PagamentoCartao cardPayment) {
        if (cardPayment == null) {
            return null;
        }
        return new CardPaymentResponse(
                cardPayment.getId(),
                bookingMapper.toResponseDTO(cardPayment.getReserva()),
                cardPayment.getCardBrand(),
                cardPayment.getEncryptedCardNumber(),
                cardPayment.getExpirationMonth(),
                cardPayment.getExpirationYear(),
                cardPayment.getAuthorizationDate(),
                cardPayment.getCreatedAt(),
                cardPayment.getUpdatedAt()
        );
    }

    @Mapping(source = "idBooking", target = "reserva", qualifiedByName = "mapBooking")
    public abstract void updateEntity(UpdateCardPaymentRequest request, @MappingTarget PagamentoCartao cardPayment);

    @Named("mapBooking")
    protected Reserva mapBooking(Long idBooking) {
        if (idBooking == null) {
            return null;
        }
        return bookingRepository.findById(idBooking).orElse(null);
    }
}
