package com.adrian.sv.service;

import com.adrian.sv.dto.request.connection.CreateConnectionRequest;
import com.adrian.sv.dto.request.connection.UpdateConnectionRequest;
import com.adrian.sv.dto.response.ConnectionResponse;

import java.util.List;

public interface ConnectionService {
    ConnectionResponse create(CreateConnectionRequest request);
    List<ConnectionResponse> findAll();
    ConnectionResponse findById(Long id);
    ConnectionResponse update(Long id, UpdateConnectionRequest request);
    void delete(Long id);
}
