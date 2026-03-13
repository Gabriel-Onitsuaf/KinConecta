package org.generation.socialNetwork.users.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.users.dto.UserCreateRequestDTO;
import org.generation.socialNetwork.users.dto.UserResponseDTO;
import org.generation.socialNetwork.users.dto.UserUpdateRequestDTO;
import org.generation.socialNetwork.users.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar User.
 * Endpoint base: /api/users
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    // Endpoint: POST /api/users - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/users - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/users/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/users/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable("id") Long id, @RequestBody UserUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/users/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
