package com.grupo1.cursosvulcano.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "academic_progress")
@Data
public class AcademicProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // El usuario que está realizando el reto

    @ManyToOne
    @JoinColumn(name = "challenge_id")
    private Challenge challenge; // El reto específico que se está midiendo

    private String status; // Estado: "STARTED", "COMPLETED", "FAILED"
    private Double score; // Calificación obtenida (0.0 a 100.0)
    private LocalDate completionDate; // Fecha exacta en que terminó el reto

    // Getters y Setters
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public LocalDate getCompletionDate() { return completionDate; }
    public void setCompletionDate(LocalDate completionDate) { this.completionDate = completionDate; }

}
