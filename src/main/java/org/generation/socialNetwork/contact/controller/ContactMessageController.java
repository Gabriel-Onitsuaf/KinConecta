package org.generation.socialNetwork.contact.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.contact.dto.ContactMessageCreateRequestDTO;
import org.generation.socialNetwork.contact.dto.ContactMessageResponseDTO;
import org.generation.socialNetwork.contact.dto.ContactMessageUpdateRequestDTO;
import org.generation.socialNetwork.contact.service.ContactMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar ContactMessage.
 * Endpoint base: /api/contact_messages
 */
@RestController
@RequestMapping("/api/contact_messages")
@RequiredArgsConstructor
public class ContactMessageController {

    private final ContactMessageService service;

    // Endpoint: POST /api/contact_messages - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<ContactMessageResponseDTO> create(@RequestBody ContactMessageCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/contact_messages - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<ContactMessageResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/contact_messages/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<ContactMessageResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/contact_messages/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<ContactMessageResponseDTO> update(@PathVariable("id") Long id, @RequestBody ContactMessageUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/contact_messages/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
