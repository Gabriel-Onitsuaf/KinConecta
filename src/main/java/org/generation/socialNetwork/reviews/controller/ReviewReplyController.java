package org.generation.socialNetwork.reviews.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.reviews.dto.ReviewReplyCreateRequestDTO;
import org.generation.socialNetwork.reviews.dto.ReviewReplyResponseDTO;
import org.generation.socialNetwork.reviews.dto.ReviewReplyUpdateRequestDTO;
import org.generation.socialNetwork.reviews.service.ReviewReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar ReviewReply.
 * Endpoint base: /api/review_replies
 */
@RestController
@RequestMapping("/api/review_replies")
@RequiredArgsConstructor
public class ReviewReplyController {

    private final ReviewReplyService service;

    // Endpoint: POST /api/review_replies - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<ReviewReplyResponseDTO> create(@RequestBody ReviewReplyCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/review_replies - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<ReviewReplyResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/review_replies/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<ReviewReplyResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/review_replies/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<ReviewReplyResponseDTO> update(@PathVariable("id") Long id, @RequestBody ReviewReplyUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/review_replies/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
