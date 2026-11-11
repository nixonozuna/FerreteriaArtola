package com.example.sitemaferreteriaartola.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "usuario", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class usuarioentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer idusuario;

    @NotNull(message = "El rol es obligatorio")
    @ManyToOne
    @JoinColumn(name = "orol", nullable = false)
    private rolentity orol;

    @NotBlank(message = "Los nombres son obligatorios")
    @Column(name = "nombres", length = 50, nullable = false)
    private String nombres;

    @NotBlank(message = "Los apellidos son obligatorios")
    @Column(name = "apellidos", length = 50, nullable = false)
    private String apellidos;

    @NotBlank(message = "El sexo es obligatorio")
    @Column(name = "sexo", length = 10, nullable = false)
    private String sexo;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechanacimiento", nullable = false)
    private Date fechanacimiento;

    @NotBlank(message = "El teléfono es obligatorio")
    @Column(name = "telefono", length = 9, nullable = false)
    private String telefono;

    @NotBlank(message = "La cédula es obligatoria")
    @Column(name = "cedula", length = 16, nullable = false, unique = true)
    private String cedula;

    @NotBlank(message = "La dirección es obligatoria")
    @Column(name = "direccion", length = 100, nullable = false)
    private String direccion;

    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Column(name = "nombreusuario", length = 30, nullable = false, unique = true)
    private String nombreusuario;

    @NotBlank(message = "La contraseña es obligatoria")
    @Column(name = "contrasenausuario", length = 10, nullable = false)
    private String contraseñausuario;

    @NotNull(message = "El estado es obligatorio")
    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @Column(name = "fecharegistro", insertable = false, updatable = false)
    private LocalDateTime fecharegistro;
}