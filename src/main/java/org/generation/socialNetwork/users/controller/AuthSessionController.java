package org.generation.socialNetwork.users.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.users.dto.AuthSessionCreateRequestDTO;
import org.generation.socialNetwork.users.dto.AuthSessionResponseDTO;
import org.generation.socialNetwork.users.dto.AuthSessionUpdateRequestDTO;
import org.generation.socialNetwork.users.service.AuthSessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar AuthSession.
 * Endpoint base: /api/auth_sessions
 */
@RestController
@RequestMapping("/api/auth_sessions")
@RequiredArgsConstructor
public class AuthSessionController {

    private final AuthSessionService service;

    // Endpoint: POST /api/auth_sessions - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<AuthSessionResponseDTO> create(@RequestBody AuthSessionCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/auth_sessions - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<AuthSessionResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/auth_sessions/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<AuthSessionResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/auth_sessions/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<AuthSessionResponseDTO> update(@PathVariable("id") Long id, @RequestBody AuthSessionUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/auth_sessions/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
