package com.adrian.sv.repository;

import com.adrian.sv.model.entity.CategoriaFuncionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCategoryRepository extends JpaRepository<CategoriaFuncionario, Long> {
}
