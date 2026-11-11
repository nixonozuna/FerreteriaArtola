package com.example.sitemaferreteriaartola.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "rol", schema = "public")
@Data
public class rolentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private Long idRol;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecharegistro")
    private LocalDateTime fechaRegistro;
}