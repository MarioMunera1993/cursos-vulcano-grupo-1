package com.grupo1.cursosvulcano.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "challenges")
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // Título del reto (ej: "Suma de Arreglos")
    
    @Column(length = 1000)
    private String description; // Explicación de qué debe hacer el alumno

    private String difficulty; // Nivel: "Easy", "Medium", "Hard"

    @Column(columnDefinition = "TEXT")
    private String baseCode; // El código inicial que se le entrega al usuario

    // Relación: Un reto está presente en muchos registros de progreso
    @OneToMany(mappedBy = "challenge")
    private List<AcademicProgress> progressRecords;

    // Getters y Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getBaseCode() { return baseCode; }
    public void setBaseCode(String baseCode) { this.baseCode = baseCode; }

}
