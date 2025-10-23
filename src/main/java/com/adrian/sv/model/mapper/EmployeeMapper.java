package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.employee.CreateEmployeeRequest;
import com.adrian.sv.dto.request.employee.UpdateEmployeeRequest;
import com.adrian.sv.dto.response.EmployeeResponse;
import com.adrian.sv.model.entity.CategoriaFuncionario;
import com.adrian.sv.model.entity.Funcionario;
import com.adrian.sv.repository.EmployeeCategoryRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public abstract class EmployeeMapper {

    @Autowired
    protected EmployeeCategoryRepository employeeCategoryRepository;

    @Autowired
    protected EmployeeCategoryMapper employeeCategoryMapper;

    @Mapping(source = "idEmployeeCategory", target = "categoriaFuncionario", qualifiedByName = "mapEmployeeCategory")
    public abstract Funcionario toEntity(CreateEmployeeRequest request);

    public EmployeeResponse toResponseDTO(Funcionario employee) {
        return new EmployeeResponse(
                employee.getId(),
                employeeCategoryMapper.toResponseDTO(employee.getCategoriaFuncionario()),
                employee.getName(),
                employee.getEmail(),
                employee.getCreatedAt(),
                employee.getUpdatedAt()
        );
    };

    @Mapping(source = "idEmployeeCategory", target = "categoriaFuncionario", qualifiedByName = "mapEmployeeCategory")
    public abstract void updateEntity(UpdateEmployeeRequest request, @MappingTarget Funcionario employee);

    @Named("mapEmployeeCategory")
    protected CategoriaFuncionario mapEmployeeCategory(Long idEmployeeCategory) {
        if (idEmployeeCategory == null) {
            return null;
        }
        return employeeCategoryRepository.findById(idEmployeeCategory).orElse(null);
    }
}
