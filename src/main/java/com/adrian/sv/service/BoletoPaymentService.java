package com.adrian.sv.service;

import com.adrian.sv.dto.request.boletopayment.CreateBoletoPaymentRequest;
import com.adrian.sv.dto.request.boletopayment.UpdateBoletoPaymentRequest;
import com.adrian.sv.dto.response.BoletoPaymentResponse;

import java.util.List;
import java.util.Optional;

public interface BoletoPaymentService {
    BoletoPaymentResponse create(CreateBoletoPaymentRequest request);
    List<BoletoPaymentResponse> findAll();
    BoletoPaymentResponse findById(Long id);
    BoletoPaymentResponse update(Long id, UpdateBoletoPaymentRequest request);
    void delete(Long id);
}
