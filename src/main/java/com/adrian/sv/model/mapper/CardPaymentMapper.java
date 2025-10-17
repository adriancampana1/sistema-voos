package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.cardpayment.CreateCardPaymentRequest;
import com.adrian.sv.dto.request.cardpayment.UpdateCardPaymentRequest;
import com.adrian.sv.dto.response.CardPaymentResponse;
import com.adrian.sv.model.entity.PagamentoCartao;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CardPaymentMapper {
    PagamentoCartao toEntity(CreateCardPaymentRequest request);
    CardPaymentResponse toResponseDTO(PagamentoCartao cardPayment);
    void updateEntity(UpdateCardPaymentRequest request, @MappingTarget PagamentoCartao cardPayment);
}
