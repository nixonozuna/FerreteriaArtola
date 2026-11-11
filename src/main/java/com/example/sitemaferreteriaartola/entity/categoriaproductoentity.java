package com.example.sitemaferreteriaartola.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "categoriaproducto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class categoriaproductoentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategoriaproducto")
    private Integer idcategoriaproducto;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 100, nullable = true)
    private String descripcion;

    @Column(name = "fecharegistro", insertable = false, updatable = false)
    private LocalDateTime fecharegistro;
}