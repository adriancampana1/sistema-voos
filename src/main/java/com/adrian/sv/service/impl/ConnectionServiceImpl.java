package com.adrian.sv.service.impl;

import com.adrian.sv.dto.request.connection.CreateConnectionRequest;
import com.adrian.sv.dto.request.connection.UpdateConnectionRequest;
import com.adrian.sv.dto.response.ConnectionResponse;
import com.adrian.sv.model.entity.EscalaVoo;
import com.adrian.sv.model.mapper.ConnectionMapper;
import com.adrian.sv.repository.ConnectionRepository;
import com.adrian.sv.service.ConnectionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ConnectionServiceImpl implements ConnectionService {

    private final ConnectionRepository connectionRepository;
    private final ConnectionMapper connectionMapper;


    @Override
    public ConnectionResponse create(CreateConnectionRequest request) {
        try {
            EscalaVoo connection = this.connectionMapper.toEntity(request);
            EscalaVoo savedConnection = this.connectionRepository.save(connection);
            return this.connectionMapper.toResponseDTO(savedConnection);
        } catch (Exception e) {
            log.error("Falha ao criar escala. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao criar escala.");
        }
    }

    @Override
    public List<ConnectionResponse> findAll() {
        try {
            List<EscalaVoo> connections = this.connectionRepository.findAll();
            return connections.stream().map(this.connectionMapper::toResponseDTO).toList();
        } catch (Exception e) {
            log.error("Falha ao listar escalas. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao listar escalas.");
        }
    }

    @Override
    public ConnectionResponse findById(Long id) {
        try {
            EscalaVoo connection = this.connectionRepository.findById(id).orElseThrow(() -> new BadRequestException("Escala não encontrada"));
            return this.connectionMapper.toResponseDTO(connection);
        } catch (Exception e) {
            log.error("Falha ao buscar escala. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao buscar escala.");
        }
    }
    @Override
    public ConnectionResponse update(Long id, UpdateConnectionRequest request) {
        try {
            EscalaVoo connection = this.connectionRepository.findById(id).orElseThrow(() -> new BadRequestException("Escala não encontrada"));
            this.connectionMapper.updateEntity(request, connection);
            EscalaVoo updatedConnection = this.connectionRepository.save(connection);
            return this.connectionMapper.toResponseDTO(updatedConnection);
        } catch (Exception e) {
            log.error("Falha ao atualizar escala. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao atualizar escala.");
        }
    }
    @Override
    public void delete(Long id) {
        try {
            EscalaVoo connection = this.connectionRepository.findById(id).orElseThrow(() -> new BadRequestException("Escala não encontrada"));
            this.connectionRepository.delete(connection);
        } catch (Exception e) {
            log.error("Falha ao deletar escala. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao deletar escala.");
        }
    }
}
