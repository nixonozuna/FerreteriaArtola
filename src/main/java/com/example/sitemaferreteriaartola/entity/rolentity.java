package com.example.sitemaferreteriaartola.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "Rol")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class rolentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdRol")
    private Integer idrol;

    @Column(name = "CodigoRol", length = 10, nullable = false, unique = true)
    private String codigorol;

    @Column(name = "Descripcion", length = 50, nullable = false)
    private String descripcion;

    @Column(name = "FechaRegistro", insertable = false, updatable = false)
    private LocalDateTime fecharegistro;
}