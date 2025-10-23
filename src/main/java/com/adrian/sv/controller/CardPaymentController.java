package com.adrian.sv.controller;

import com.adrian.sv.dto.request.cardpayment.CreateCardPaymentRequest;
import com.adrian.sv.dto.request.cardpayment.UpdateCardPaymentRequest;
import com.adrian.sv.dto.response.CardPaymentResponse;
import com.adrian.sv.service.CardPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card-payments")
@AllArgsConstructor
public class CardPaymentController {

    private final CardPaymentService cardPaymentService;

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public CardPaymentResponse create(@RequestBody() CreateCardPaymentRequest request) {
        return this.cardPaymentService.create(request);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public List<CardPaymentResponse> findAll() {
        return this.cardPaymentService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public CardPaymentResponse findById(@PathVariable("id") Long id) {
        return this.cardPaymentService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public CardPaymentResponse update(@PathVariable("id") Long id, @RequestBody() UpdateCardPaymentRequest request) {
        return this.cardPaymentService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable("id") Long id) {
        this.cardPaymentService.delete(id);
    }
}
