package com.adrian.sv.service.impl;

import com.adrian.sv.dto.request.employeecategory.CreateEmployeeCategoryRequest;
import com.adrian.sv.dto.request.employeecategory.UpdateEmployeeCategoryRequest;
import com.adrian.sv.dto.response.EmployeeCategoryResponse;
import com.adrian.sv.model.entity.CategoriaFuncionario;
import com.adrian.sv.model.mapper.EmployeeCategoryMapper;
import com.adrian.sv.repository.EmployeeCategoryRepository;
import com.adrian.sv.service.EmployeeCategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class EmployeeCategoryServiceImpl implements EmployeeCategoryService {

    private final EmployeeCategoryRepository employeeCategoryRepository;
    private final EmployeeCategoryMapper employeeCategoryMapper;

    @Override
    public EmployeeCategoryResponse create(CreateEmployeeCategoryRequest request) {
        try {
            CategoriaFuncionario employeeCategory = this.employeeCategoryMapper.toEntity(request);
            CategoriaFuncionario savedEmployeeCategory = this.employeeCategoryRepository.save(employeeCategory);
            return this.employeeCategoryMapper.toResponseDTO(savedEmployeeCategory);
        } catch (Exception e) {
            log.error("Falha ao criar categoria de funcionario. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao criar categoria de funcionario.");
        }
    }

    @Override
    public List<EmployeeCategoryResponse> findAll() {
        try {
            List<CategoriaFuncionario> employeeCategories = this.employeeCategoryRepository.findAll();
            return employeeCategories.stream().map(this.employeeCategoryMapper::toResponseDTO).toList();
        } catch (Exception e) {
            log.error("Falha ao listar categorias de funcionarios. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao listar categorias de funcionarios.");
        }
    }

    @Override
    public EmployeeCategoryResponse findById(Long id) {
        try {
            CategoriaFuncionario employeeCategory = this.employeeCategoryRepository.findById(id).orElseThrow(() -> new BadRequestException("Categoria de funcionario não encontrada"));
            return this.employeeCategoryMapper.toResponseDTO(employeeCategory);
        } catch (Exception e) {
            log.error("Falha ao buscar categoria de funcionario. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao buscar categoria de funcionario.");
        }
    }

    @Override
    public EmployeeCategoryResponse update(Long id, UpdateEmployeeCategoryRequest request) {
        try {
            CategoriaFuncionario employeeCategory = this.employeeCategoryRepository.findById(id).orElseThrow(() -> new BadRequestException("Categoria de funcionario não encontrada"));
            this.employeeCategoryMapper.toResponseDTO(employeeCategory);
            CategoriaFuncionario updatedEmployeeCategory = this.employeeCategoryRepository.save(employeeCategory);
            return this.employeeCategoryMapper.toResponseDTO(updatedEmployeeCategory);
        } catch (Exception e) {
            log.error("Falha ao atualizar categoria de funcionario. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao atualizar categoria de funcionario.");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            CategoriaFuncionario employeeCategory = this.employeeCategoryRepository.findById(id).orElseThrow(() -> new BadRequestException("Categoria de funcionario não encontrada"));
            this.employeeCategoryRepository.delete(employeeCategory);
        } catch (Exception e) {
            log.error("Falha ao deletar categoria de funcionario. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao deletar categoria de funcionario.");
        }
    }
}
