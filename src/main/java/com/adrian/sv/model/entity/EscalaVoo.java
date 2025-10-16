package com.adrian.sv.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "escalas_voo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EscalaVoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_escala")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_voo", nullable = false)
    private Voo voo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aeroporto", nullable = false)
    private Aeroporto aeroporto;

    private Integer ordemEscala;
    private LocalDate departureDate;
    private LocalTime scheduledDepartureTime;
    private LocalDate arrivalDate;
    private LocalTime scheduledArrivalTime;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "EscalaVoo{" +
                "id=" + id +
                ", voo=" + voo +
                ", aeroporto=" + aeroporto +
                ", ordemEscala=" + ordemEscala +
                ", departureDate=" + departureDate +
                ", scheduledDepartureTime=" + scheduledDepartureTime +
                ", arrivalDate=" + arrivalDate +
                ", scheduledArrivalTime=" + scheduledArrivalTime +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
