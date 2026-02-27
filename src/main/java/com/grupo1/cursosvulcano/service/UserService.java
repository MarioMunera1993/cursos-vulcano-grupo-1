package com.grupo1.cursosvulcano.service;

import org.springframework.stereotype.Service;

import com.grupo1.cursosvulcano.repository.UserRepository;
import com.grupo1.cursosvulcano.model.User;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    
    // Inyección de dependencias por constructor (más seguro que @Autowired)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Método para registrar un nuevo usuario
    public User registrarUsuario(User user) {
        // En un entorno real, aquí encriptaríamos la contraseña antes de guardar
        return userRepository.save(user);
    }

    // Método para obtener la lista de todos los usuarios
    public List<User> obtenerTodos() {
        return userRepository.findAll();
    }

    // Método para buscar un usuario por su ID
    public User buscarPorId(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }
}
