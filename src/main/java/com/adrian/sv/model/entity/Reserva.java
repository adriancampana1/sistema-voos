package com.adrian.sv.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_passageiro", nullable = false)
    private Passageiro passageiro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_voo", nullable = false)
    private Voo voo;

    private String bookingNumber;
    private LocalDate purchaseDate;
    private BigDecimal totalAmount;
    private String paymentMethod;
    private String paymentStatus;
    private LocalDate confirmationDate;
    private LocalDate cancellationDate;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", passageiro=" + passageiro +
                ", voo=" + voo +
                ", purchaseDate=" + purchaseDate +
                ", totalAmount=" + totalAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", confirmationDate=" + confirmationDate +
                ", cancellationDate=" + cancellationDate +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
