package com.grupo1.cursosvulcano.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único de la reseña

    @Column(columnDefinition = "TEXT")
    private String comment; // El texto detallado con la opinión del usuario

    private int rating; // Calificación numérica (ej: de 1 a 5 estrellas)

    @Column(updatable = false)
    private LocalDateTime createdAt; // Fecha y hora automática de creación

    private LocalDateTime updatedAt; // Fecha y hora de la última actualización

    // Relación: Muchas reseñas pertenecen a un solo Usuario (Muchos a Uno)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Quién escribió la reseña

    // Constructor vacío (obligatorio para JPA)
    public Review() {
    }

    // Getters y Setters Manuales
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
