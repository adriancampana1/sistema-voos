package com.adrian.sv.repository;

import com.adrian.sv.model.entity.Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passageiro, Long> {
    Optional<Passageiro> findByEmail(String email);
    Optional<Passageiro> findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByCpf(String cpf);
}
