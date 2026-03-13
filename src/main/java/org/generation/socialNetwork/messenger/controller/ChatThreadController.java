package org.generation.socialNetwork.messenger.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.messenger.dto.ChatThreadCreateRequestDTO;
import org.generation.socialNetwork.messenger.dto.ChatThreadResponseDTO;
import org.generation.socialNetwork.messenger.dto.ChatThreadUpdateRequestDTO;
import org.generation.socialNetwork.messenger.service.ChatThreadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar ChatThread.
 * Endpoint base: /api/chat_threads
 */
@RestController
@RequestMapping("/api/chat_threads")
@RequiredArgsConstructor
public class ChatThreadController {

    private final ChatThreadService service;

    // Endpoint: POST /api/chat_threads - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<ChatThreadResponseDTO> create(@RequestBody ChatThreadCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/chat_threads - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<ChatThreadResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/chat_threads/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<ChatThreadResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/chat_threads/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<ChatThreadResponseDTO> update(@PathVariable("id") Long id, @RequestBody ChatThreadUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/chat_threads/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
