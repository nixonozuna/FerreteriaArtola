package com.example.sitemaferreteriaartola.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "Permiso")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class permisoentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPermiso")
    private Integer idpermiso;

    @Column(name = "CodigoPermiso", length = 10, nullable = false, unique = true)
    private String codigopermiso;

    @Column(name = "NombreMenu", length = 50, nullable = false)
    private String nombremenu;

    @Column(name = "FechaRegistro", insertable = false, updatable = false)
    private LocalDateTime fecharegistro;
}
