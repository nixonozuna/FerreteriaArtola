package com.example.sitemaferreteriaartola.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Proveedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class proveedorentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProveedor")
    private Integer idproveedor;

    @Column(name = "CodigoProveedor", unique = true, length = 10, nullable = false)
    private String codigoproveedor;

    @Column(name = "RazonSocial", length = 50, nullable = false)
    private String razonsocial;

    @Column(name = "Email", length = 50, nullable = true)
    private String email;

    @Column(name = "Telefono", length = 9, nullable = false)
    private String telefono;

    @Column(name = "Direccion", length = 100, nullable = false)
    private String direccion;

    @Column(name = "Estado", nullable = false)
    private Boolean estado;

    @Column(name = "FechaRegistro", insertable = false, updatable = false)
    private LocalDateTime fecharegistro;
}