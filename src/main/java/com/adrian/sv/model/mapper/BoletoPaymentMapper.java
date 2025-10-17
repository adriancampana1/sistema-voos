package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.boletopayment.CreateBoletoPaymentRequest;
import com.adrian.sv.dto.request.boletopayment.UpdateBoletoPaymentRequest;
import com.adrian.sv.dto.response.BoletoPaymentResponse;
import com.adrian.sv.model.entity.PagamentoBoleto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface BoletoPaymentMapper {

    PagamentoBoleto toEntity(CreateBoletoPaymentRequest request);
    BoletoPaymentResponse toResponseDTO(PagamentoBoleto boletoPayment);
    void updateEntity(UpdateBoletoPaymentRequest request, @MappingTarget PagamentoBoleto boletoPayment);
}
