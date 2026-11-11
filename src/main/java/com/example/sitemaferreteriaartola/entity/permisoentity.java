package com.example.sitemaferreteriaartola.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "permiso")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class permisoentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpermiso")
    private Integer idpermiso;

    @NotNull(message = "El rol es obligatorio")
    @ManyToOne
    @JoinColumn(name = "orol", nullable = false)
    private rolentity orol;

    @Column(name = "nombremenu", length = 50, nullable = false)
    private String nombremenu;

    @Column(name = "fecharegistro", insertable = false, updatable = false)
    private LocalDateTime fecharegistro;
}