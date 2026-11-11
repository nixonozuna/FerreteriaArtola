package com.example.sitemaferreteriaartola.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "CategoriaProducto")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class categoriaproductoentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCategoriaProducto")
    private Integer idcategoriaproducto;

    @Column(name = "CodigoCategoriaProducto", length = 11, nullable = false, unique = true)
    private String codigocategoriaproducto;

    @NotNull(message = "El nombre es obligatorio")
    @Column(name = "Nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "Descripcion", length = 100, nullable = true)
    private String descripcion;

    @Column(name = "FechaRegistro", insertable = false, updatable = false)
    private LocalDateTime fecharegistro;
}
