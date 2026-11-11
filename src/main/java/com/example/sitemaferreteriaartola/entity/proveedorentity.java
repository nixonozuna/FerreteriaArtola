package com.example.sitemaferreteriaartola.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "proveedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class proveedorentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproveedor")
    private Integer idproveedor;

    @NotBlank(message = "La razón social es obligatoria")
    @Column(name = "razonsocial", length = 50, nullable = false)
    private String razonsocial;

    @Column(name = "email", length = 100, nullable = true)
    private String email;

    @NotBlank(message = "El teléfono es obligatorio")
    @Column(name = "telefono", length = 9, nullable = false)
    private String telefono;

    @Column(name = "direccion", length = 100, nullable = true)
    private String direccion;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @Column(name = "fecharegistro", insertable = false, updatable = false)
    private LocalDateTime fecharegistro;
}