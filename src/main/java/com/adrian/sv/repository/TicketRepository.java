package com.adrian.sv.repository;

import com.adrian.sv.model.entity.Passagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Passagem, Long> {
}
