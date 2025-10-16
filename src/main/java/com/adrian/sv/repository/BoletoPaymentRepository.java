package com.adrian.sv.repository;

import com.adrian.sv.model.entity.PagamentoBoleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletoPaymentRepository extends JpaRepository<PagamentoBoleto, Long> {
}
