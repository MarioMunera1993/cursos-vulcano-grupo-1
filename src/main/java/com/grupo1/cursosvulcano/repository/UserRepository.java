package com.grupo1.cursosvulcano.repository;
import com.grupo1.cursosvulcano.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Aquí vanmétodos personalizados,

    //Buscar por email (para login)
    Optional<User> findByUsername(String email);

}
