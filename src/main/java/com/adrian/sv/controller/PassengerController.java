package com.adrian.sv.controller;

import com.adrian.sv.dto.request.passenger.CreatePassengerRequest;
import com.adrian.sv.dto.request.passenger.UpdatePassengerRequest;
import com.adrian.sv.dto.response.PassengerResponse;
import com.adrian.sv.model.entity.Passageiro;
import com.adrian.sv.service.PassengerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passenger")
@AllArgsConstructor
public class PassengerController {

    private final PassengerService passengerService;

    @PostMapping
    public PassengerResponse create(@RequestBody() CreatePassengerRequest request) {
        return this.passengerService.create(request);
    }

    @GetMapping
    public List<PassengerResponse> findAll() {
        return this.passengerService.findAll();
    }

    @GetMapping("/{id}")
    public PassengerResponse findById(@PathVariable("id") Long id) {
        return this.passengerService.findById(id);
    }

    @PutMapping("/{id}")
    public PassengerResponse update(@PathVariable("id") Long id, @RequestBody() UpdatePassengerRequest request) {
        return this.passengerService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.passengerService.delete(id);
    }
}
