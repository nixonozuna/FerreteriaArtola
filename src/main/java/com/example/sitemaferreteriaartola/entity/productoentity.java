package com.example.sitemaferreteriaartola.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "Producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class productoentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProducto")
    private Integer idproducto;

    @Column(name = "CodigoProducto", length = 10, nullable = false, unique = true)
    private String codigoproducto;

    @NotBlank(message = "El código de barra es obligatorio")
    @Column(name = "CodigoBarra", length = 10, nullable = false, unique = true)
    private String codigobarra;

    @NotNull(message = "La categoría es obligatoria")
    @ManyToOne
    @JoinColumn(name = "oCategoriaProducto", nullable = false)
    private categoriaproductoentity ocategoriaproducto;

    @NotNull(message = "La unidad de medida es obligatoria")
    @ManyToOne
    @JoinColumn(name = "oUnidadMedida", nullable = false)
    private unidadmedidaentity ounidadmedida;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(name = "Nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "Descripcion", length = 100, nullable = true)
    private String descripcion;

    @NotNull(message = "El stock inicial es obligatorio")
    @Column(name = "Stock", nullable = false)
    private Integer stock;

    @Column(name = "Estado", nullable = false)
    private Boolean estado = true;

    @Column(name = "FechaRegistro", insertable = false, updatable = false)
    private LocalDateTime fecharegistro;
}