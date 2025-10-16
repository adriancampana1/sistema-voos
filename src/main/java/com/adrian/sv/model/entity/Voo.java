package com.adrian.sv.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "voos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Voo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voo")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_voo", nullable = false)
    private TipoVoo tipoVoo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_aeronave", nullable = false)
    private TipoAeronave tipoAeronave;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aeroporto_origem", nullable = false)
    private Aeroporto aeroportoOrigem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aeroporto_destino", nullable = false)
    private Aeroporto aeroportoDestino;

    private LocalDate departureDate;
    private LocalTime scheduledDepartureTime;
    private LocalDate arrivalDate;
    private LocalTime scheduledArrivalTime;
    private LocalTime scheduledDurationMin;
    private String status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "Voo{" +
                "id=" + id +
                ", tipoVoo=" + tipoVoo +
                ", tipoAeronave=" + tipoAeronave +
                ", aeroportoOrigem=" + aeroportoOrigem +
                ", aeroportoDestino=" + aeroportoDestino +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
