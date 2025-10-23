package com.adrian.sv.service.impl;

import com.adrian.sv.dto.request.ticket.CreateTicketRequest;
import com.adrian.sv.dto.request.ticket.UpdateTicketRequest;
import com.adrian.sv.dto.response.TicketResponse;
import com.adrian.sv.model.entity.Passagem;
import com.adrian.sv.model.mapper.TicketMapper;
import com.adrian.sv.repository.TicketRepository;
import com.adrian.sv.service.TicketService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Override
    public TicketResponse create(CreateTicketRequest request) {
        try {
            Passagem ticket = this.ticketMapper.toEntity(request);
            Passagem savedTicket = this.ticketRepository.save(ticket);
            return this.ticketMapper.toResponseDTO(savedTicket);
        } catch (Exception e) {
            log.error("Falha ao criar passagem. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao criar passagem.");
        }
    }

    @Override
    public List<TicketResponse> findAll() {
        try {
            List<Passagem> tickets = this.ticketRepository.findAll();
            return tickets.stream().map(this.ticketMapper::toResponseDTO).toList();
        } catch (Exception e) {
            log.error("Falha ao listar passagens. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao listar passagens.");
        }
    }

    @Override
    public TicketResponse findById(Long id) {
        try {
            Passagem ticket = this.ticketRepository.findById(id).orElseThrow(() -> new BadRequestException("Passagem não encontrada!"));
            return this.ticketMapper.toResponseDTO(ticket);
        } catch (Exception e) {
            log.error("Falha ao buscar passagem. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao buscar passagem.");
        }
    }

    @Override
    public TicketResponse update(Long id, UpdateTicketRequest request) {
        try {
            Passagem ticket = this.ticketRepository.findById(id).orElseThrow(() -> new BadRequestException("Passagem não encontrada!"));
            this.ticketMapper.updateEntity(request, ticket);
            Passagem updatedTicket = this.ticketRepository.save(ticket);
            return this.ticketMapper.toResponseDTO(updatedTicket);
        } catch (Exception e) {
            log.error("Falha ao atualizar passagem. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao atualizar passagem.");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Passagem ticket = this.ticketRepository.findById(id).orElseThrow(() -> new BadRequestException("Passagem não encontrada!"));
            this.ticketRepository.delete(ticket);
        } catch (Exception e) {
            log.error("Falha ao deletar passagem. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao deletar passagem.");
        }
    }
}
