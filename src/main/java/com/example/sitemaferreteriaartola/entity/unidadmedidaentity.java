package com.example.sitemaferreteriaartola.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "unidadmedida")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class unidadmedidaentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idunidadmedida")
    private Integer idunidadmedida;

    @NotBlank(message = "El nombre de la unidad de medida es obligatorio")
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "fecharegistro", insertable = false, updatable = false)
    private LocalDateTime fecharegistro;
}