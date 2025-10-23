package com.adrian.sv.service.impl;

import com.adrian.sv.dto.request.employee.CreateEmployeeRequest;
import com.adrian.sv.dto.request.employee.UpdateEmployeeRequest;
import com.adrian.sv.dto.response.EmployeeResponse;
import com.adrian.sv.model.entity.Funcionario;
import com.adrian.sv.model.mapper.EmployeeMapper;
import com.adrian.sv.repository.EmployeeRepository;
import com.adrian.sv.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeResponse create(CreateEmployeeRequest request) {
        try {
            Funcionario employee = this.employeeMapper.toEntity(request);
            Funcionario savedEmployee = this.employeeRepository.save(employee);
            return this.employeeMapper.toResponseDTO(savedEmployee);
        } catch (Exception e) {
            log.error("Falha ao criar funcionario. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao criar funcionario.");
        }
    }

    @Override
    public List<EmployeeResponse> findAll() {
        try {
            List<Funcionario> employeeList = this.employeeRepository.findAll();
            return employeeList.stream().map(this.employeeMapper::toResponseDTO).toList();
        } catch (Exception e) {
            log.error("Falha ao listar funcionarios. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao listar funcionarios.");
        }
    }

    @Override
    public EmployeeResponse findById(Long id) {
        try {
            Funcionario employee = this.employeeRepository.findById(id).orElseThrow(() -> new BadRequestException("Funcionario não encontrado"));
            return this.employeeMapper.toResponseDTO(employee);
        } catch (Exception e) {
            log.error("Falha ao buscar funcionario. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao buscar funcionario.");
        }
    }

    @Override
    public EmployeeResponse update(Long id, UpdateEmployeeRequest request) {
        try {
            Funcionario employee = this.employeeRepository.findById(id).orElseThrow(() -> new BadRequestException("Funcionario não encontrado"));
            this.employeeMapper.updateEntity(request, employee);
            Funcionario updatedEmployee = this.employeeRepository.save(employee);
            return this.employeeMapper.toResponseDTO(updatedEmployee);
        } catch (Exception e) {
            log.error("Falha ao atualizar funcionario. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao atualizar funcionario.");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Funcionario employee = this.employeeRepository.findById(id).orElseThrow(() -> new BadRequestException("Funcionario não encontrado"));
            this.employeeRepository.delete(employee);
        } catch (Exception e) {
            log.error("Falha ao deletar funcionario. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao deletar funcionario.");
        }
    }
}
