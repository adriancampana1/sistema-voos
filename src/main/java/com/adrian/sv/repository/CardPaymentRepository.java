package com.adrian.sv.repository;

import com.adrian.sv.model.entity.PagamentoCartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardPaymentRepository extends JpaRepository<PagamentoCartao, Long> {
}
