package com.example.sitemaferreteriaartola.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "UnidadMedida")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class unidadmedidaentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUnidadMedida")
    private Integer idunidadmedida;

    @Column(name = "CodigoUnidadMedida", length = 10, nullable = false, unique = true)
    private String codigounidadmedida;

    @Column(name = "Nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "FechaRegistro", insertable = false, updatable = false)
    private LocalDateTime fecharegistro;
}