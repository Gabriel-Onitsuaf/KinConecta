package org.generation.socialNetwork.notifications.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.notifications.dto.NotificationCreateRequestDTO;
import org.generation.socialNetwork.notifications.dto.NotificationResponseDTO;
import org.generation.socialNetwork.notifications.dto.NotificationUpdateRequestDTO;
import org.generation.socialNetwork.notifications.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar Notification.
 * Endpoint base: /api/notifications
 */
@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService service;

    // Endpoint: POST /api/notifications - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<NotificationResponseDTO> create(@RequestBody NotificationCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/notifications - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<NotificationResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/notifications/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<NotificationResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/notifications/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<NotificationResponseDTO> update(@PathVariable("id") Long id, @RequestBody NotificationUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/notifications/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
