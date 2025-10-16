package com.adrian.sv.repository;

import com.adrian.sv.model.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Reserva, Long> {
}
