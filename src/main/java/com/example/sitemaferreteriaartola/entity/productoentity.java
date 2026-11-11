package com.example.sitemaferreteriaartola.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class productoentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private Integer idproducto;

    @NotBlank(message = "El código de barra es obligatorio")
    @Column(name = "codigobarra", length = 10, nullable = false, unique = true)
    private String codigobarra;

    @NotNull(message = "La categoría es obligatoria")
    @ManyToOne
    @JoinColumn(name = "ocategoriaproducto", nullable = false)
    private categoriaproductoentity ocategoriaproducto;

    @ManyToOne
    @JoinColumn(name = "ounidadmedida", nullable = true)
    private unidadmedidaentity ounidadmedida;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 100, nullable = true)
    private String descripcion;

    @NotNull(message = "El stock es obligatorio")
    @Column(name = "stock", nullable = false)
    private Integer stock;

    @NotNull(message = "El estado es obligatorio")
    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @Column(name = "fecharegistro", insertable = false, updatable = false)
    private LocalDateTime fecharegistro;
}