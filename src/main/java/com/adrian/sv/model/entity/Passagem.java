package com.adrian.sv.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "passagens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_passagem")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reserva reserva;

    private String passengerName;
    private Integer seatNumber;
    private Boolean checkInCompleted;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "Passagem{" +
                "id=" + id +
                ", reserva=" + reserva +
                ", passengerName='" + passengerName + '\'' +
                ", seatNumber=" + seatNumber +
                ", checkInCompleted=" + checkInCompleted +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
