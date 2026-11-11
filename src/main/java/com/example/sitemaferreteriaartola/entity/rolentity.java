package com.example.sitemaferreteriaartola.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "rol", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class rolentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private Integer idrol;

    @Column(name = "descripcion", length = 50, nullable = false)
    private String descripcion;

    @Column(name = "fecharegistro", insertable = false, updatable = false)
    private LocalDateTime fecharegistro;
}