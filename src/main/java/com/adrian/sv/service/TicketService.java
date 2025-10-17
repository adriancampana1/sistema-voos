package com.adrian.sv.service;

import com.adrian.sv.dto.request.ticket.CreateTicketRequest;
import com.adrian.sv.dto.request.ticket.UpdateTicketRequest;
import com.adrian.sv.dto.response.TicketResponse;

import java.util.List;

public interface TicketService {
    TicketResponse create(CreateTicketRequest request);
    List<TicketResponse> findAll();
    TicketResponse findById(Long id);
    TicketResponse update(Long id, UpdateTicketRequest request);
    void delete(Long id);
}
