package com.adrian.sv.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagamentos_cartao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagamentoCartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento_cartao")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reserva reserva;

    private String cardBrand;
    private String encryptedCardNumber;
    private Short expirationMonth;
    private Short expirationYear;

    private LocalDateTime authorizationDate;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "PagamentoCartao{" +
                "id=" + id +
                ", reserva=" + reserva +
                ", cardBrand='" + cardBrand + '\'' +
                ", encryptedCardNumber='" + encryptedCardNumber + '\'' +
                ", expirationMonth=" + expirationMonth +
                ", expirationYear=" + expirationYear +
                ", authorizationDate=" + authorizationDate +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
