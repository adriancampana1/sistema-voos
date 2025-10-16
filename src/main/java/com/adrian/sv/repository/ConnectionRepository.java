package com.adrian.sv.repository;

import com.adrian.sv.model.entity.EscalaVoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectionRepository extends JpaRepository<EscalaVoo, Long> {
}
