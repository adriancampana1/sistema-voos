package com.adrian.sv.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "passageiros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passageiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_passageiro")
    private Long id;

    private String email;
    private String username;

    @JsonIgnore
    private String password;

    private String cpf;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "passageiro", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @Builder.Default
    private List<Reserva> reservas = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "id_passageiro"),
        inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    @Builder.Default
    private Set<Role> roles = new HashSet<>();

    @Override
    public String toString() {
        return "Passageiro{" +
                "cpf='" + cpf + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", reservas=" + reservas +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
}
