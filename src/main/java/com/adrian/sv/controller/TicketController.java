package com.adrian.sv.controller;

import com.adrian.sv.dto.request.ticket.CreateTicketRequest;
import com.adrian.sv.dto.request.ticket.UpdateTicketRequest;
import com.adrian.sv.dto.response.TicketResponse;
import com.adrian.sv.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@AllArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public TicketResponse create(@RequestBody() CreateTicketRequest request) {
        return this.ticketService.create(request);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public List<TicketResponse> findAll() {
        return this.ticketService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public TicketResponse findById(@PathVariable("id") Long id) {
        return this.ticketService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public TicketResponse update(@PathVariable("id") Long id, @RequestBody() UpdateTicketRequest request) {
        return this.ticketService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public void delete(@PathVariable("id") Long id) {
        this.ticketService.delete(id);
    }
}
