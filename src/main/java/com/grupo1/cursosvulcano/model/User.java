package com.grupo1.cursosvulcano.model;

import java.time.LocalDateTime;
import java.util.List;

import com.grupo1.cursosvulcano.model.AcademicProgress;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único incremental

    @Column(nullable = false, unique = true)
    private String username; // Nombre de usuario para el login

    @Column(nullable = false, unique = true)
    private String email; // Correo electrónico del estudiante

    @Column(nullable = false)
    private String password; // Contraseña (debe guardarse encriptada)

    @Column(updatable = false)
    private LocalDateTime createdAt; // Fecha y hora en que se registró

    private LocalDateTime updatedAt; // Fecha y hora de la última modificación

    // Relaciones: Un usuario puede tener muchas revisiones y muchos progresos
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    private List<AcademicProgress> progressRecords;

    // Getters y Setters Manuales
    public Long getId() { return id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }


}
