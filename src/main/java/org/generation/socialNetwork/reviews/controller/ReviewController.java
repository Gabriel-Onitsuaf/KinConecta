package org.generation.socialNetwork.reviews.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.reviews.dto.ReviewCreateRequestDTO;
import org.generation.socialNetwork.reviews.dto.ReviewResponseDTO;
import org.generation.socialNetwork.reviews.dto.ReviewUpdateRequestDTO;
import org.generation.socialNetwork.reviews.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar Review.
 * Endpoint base: /api/reviews
 */
@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;

    // Endpoint: POST /api/reviews - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<ReviewResponseDTO> create(@RequestBody ReviewCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/reviews - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<ReviewResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/reviews/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/reviews/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<ReviewResponseDTO> update(@PathVariable("id") Long id, @RequestBody ReviewUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/reviews/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
