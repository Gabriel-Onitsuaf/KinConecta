package org.generation.socialNetwork.messenger.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.messenger.dto.ChatMessageCreateRequestDTO;
import org.generation.socialNetwork.messenger.dto.ChatMessageResponseDTO;
import org.generation.socialNetwork.messenger.dto.ChatMessageUpdateRequestDTO;
import org.generation.socialNetwork.messenger.service.ChatMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar ChatMessage.
 * Endpoint base: /api/chat_messages
 */
@RestController
@RequestMapping("/api/chat_messages")
@RequiredArgsConstructor
public class ChatMessageController {

    private final ChatMessageService service;

    // Endpoint: POST /api/chat_messages - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<ChatMessageResponseDTO> create(@RequestBody ChatMessageCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/chat_messages - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<ChatMessageResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/chat_messages/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<ChatMessageResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/chat_messages/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<ChatMessageResponseDTO> update(@PathVariable("id") Long id, @RequestBody ChatMessageUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/chat_messages/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
