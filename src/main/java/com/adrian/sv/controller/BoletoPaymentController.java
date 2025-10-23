package com.adrian.sv.controller;

import com.adrian.sv.dto.request.boletopayment.CreateBoletoPaymentRequest;
import com.adrian.sv.dto.request.boletopayment.UpdateBoletoPaymentRequest;
import com.adrian.sv.dto.response.BoletoPaymentResponse;
import com.adrian.sv.service.BoletoPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boleto-payments")
@AllArgsConstructor
public class BoletoPaymentController {

    private final BoletoPaymentService boletoPaymentService;

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public BoletoPaymentResponse create(@RequestBody() CreateBoletoPaymentRequest request) {
        return this.boletoPaymentService.create(request);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public List<BoletoPaymentResponse> findAll() {
        return this.boletoPaymentService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public BoletoPaymentResponse findById(@PathVariable("id") Long id) {
        return this.boletoPaymentService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public BoletoPaymentResponse update(@PathVariable("id") Long id, @RequestBody()UpdateBoletoPaymentRequest request) {
        return this.boletoPaymentService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable("id") Long id) {
        this.boletoPaymentService.delete(id);
    }
}
