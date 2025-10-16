package com.adrian.sv.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "aeronaves")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Aeronave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aeronave")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_aeronave", nullable = false)
    private TipoAeronave tipoAeronave;

    private String registration;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "Aeronave{" +
                "id=" + id +
                ", tipoAeronave=" + tipoAeronave +
                ", registration='" + registration + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
