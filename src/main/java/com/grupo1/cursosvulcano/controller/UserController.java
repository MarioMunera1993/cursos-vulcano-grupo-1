package com.grupo1.cursosvulcano.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.grupo1.cursosvulcano.service.UserService;
import com.grupo1.cursosvulcano.model.User;

import java.util.List;

@RestController
@RequestMapping("/api/users") // Ruta base para este controlador
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Crear un usuario: POST http://localhost:8080/api/users
    @PostMapping
    public ResponseEntity<User> crear(@RequestBody User user) {
        User nuevoUsuario = userService.registrarUsuario(user);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    // Listar usuarios: GET http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<User>> listar() {
        List<User> usuarios = userService.obtenerTodos();
        return ResponseEntity.ok(usuarios);
    }

    // Obtener uno: GET http://localhost:8080/api/users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<User> obtenerUno(@PathVariable Long id) {
        return ResponseEntity.ok(userService.buscarPorId(id));
    }

}
