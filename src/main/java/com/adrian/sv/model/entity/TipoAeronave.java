package com.adrian.sv.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipos_aeronave")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoAeronave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_aeronave")
    private Long id;

    private String type;
    private String description;
    private Short passengerCapacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "aircraft_category")
    private AircraftCategory aircraftCategory;

    @Column(name = "max_speed")
    private Integer maxSpeed;

    @Column(name = "range_km")
    private Integer rangeKm;

    @Column(name = "cargo_capacity_kg")
    private Long cargoCapacityKg;

    @Column(name = "max_altitude_ft")
    private Integer maxAltitudeFt;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "tipoAeronave", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Aeronave> aeronaves = new ArrayList<>();

    @OneToMany(mappedBy = "tipoAeronave")
    @Builder.Default
    private List<Voo> voos = new ArrayList<>();

    @Override
    public String toString() {
        return "TipoAeronave{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", passengerCapacity=" + passengerCapacity +
                ", aircraftCategory=" + aircraftCategory +
                ", maxSpeed=" + maxSpeed +
                ", rangeKm=" + rangeKm +
                ", cargoCapacityKg=" + cargoCapacityKg +
                ", maxAltitudeFt=" + maxAltitudeFt +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
