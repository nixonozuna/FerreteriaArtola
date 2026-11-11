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
@Table(name = "Usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class usuarioentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuario")
    private Integer idusuario;

    @Column(name = "CodigoUsuario", unique = true, length = 10, nullable = false)
    private String codigousuario;

    @NotNull(message = "El rol es obligatorio")
    @ManyToOne
    @JoinColumn(name = "oRol", nullable = false)
    private rolentity orol;

    @NotBlank(message = "Los nombres son obligatorios")
    @Column(name = "Nombres", length = 50, nullable = false)
    private String nombres;

    @NotBlank(message = "Los apellidos son obligatorios")
    @Column(name = "Apellidos", length = 50, nullable = false)
    private String apellidos;

    @NotBlank(message = "El sexo es obligatorio")
    @Column(name = "Sexo", length = 10, nullable = false)
    private String sexo;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "FechaNacimiento", nullable = false)
    private Date fechanacimiento;

    @NotBlank(message = "El teléfono es obligatorio")
    @Column(name = "Telefono", length = 9, nullable = false)
    private String telefono;

    @NotBlank(message = "La cédula es obligatoria")
    @Column(name = "Cedula", length = 16, nullable = false, unique = true)
    private String cedula;

    @NotBlank(message = "La dirección es obligatoria")
    @Column(name = "Direccion", length = 100, nullable = false)
    private String direccion;

    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Column(name = "NombreUsuario", length = 30, nullable = false, unique = true)
    private String nombreusuario;

    @NotBlank(message = "La contraseña es obligatoria")
    @Column(name = "ContraseñaUsuario", length = 10, nullable = false)
    private String contraseñausuario;

    @NotNull(message = "El estado es obligatorio")
    @Column(name = "Estado", nullable = false)
    private Boolean estado;

    @Column(name = "FechaRegistro", insertable = false, updatable = false)
    private LocalDateTime fecharegistro;
}