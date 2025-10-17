package com.adrian.sv.service;

import com.adrian.sv.dto.request.cardpayment.CreateCardPaymentRequest;
import com.adrian.sv.dto.request.cardpayment.UpdateCardPaymentRequest;
import com.adrian.sv.dto.response.CardPaymentResponse;

import java.util.List;

public interface CardPaymentService {
    CardPaymentResponse create(CreateCardPaymentRequest request);
    List<CardPaymentResponse> findAll();
    CardPaymentResponse findById(Long id);
    CardPaymentResponse update(Long id, UpdateCardPaymentRequest request);
    void delete(Long id);
}
