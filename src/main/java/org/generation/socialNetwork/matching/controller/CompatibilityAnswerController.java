package org.generation.socialNetwork.matching.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.matching.dto.CompatibilityAnswerCreateRequestDTO;
import org.generation.socialNetwork.matching.dto.CompatibilityAnswerResponseDTO;
import org.generation.socialNetwork.matching.dto.CompatibilityAnswerUpdateRequestDTO;
import org.generation.socialNetwork.matching.service.CompatibilityAnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar CompatibilityAnswer.
 * Endpoint base: /api/compatibility_answers
 */
@RestController
@RequestMapping("/api/compatibility_answers")
@RequiredArgsConstructor
public class CompatibilityAnswerController {

    private final CompatibilityAnswerService service;

    // Endpoint: POST /api/compatibility_answers - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<CompatibilityAnswerResponseDTO> create(@RequestBody CompatibilityAnswerCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/compatibility_answers - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<CompatibilityAnswerResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/compatibility_answers/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<CompatibilityAnswerResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/compatibility_answers/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<CompatibilityAnswerResponseDTO> update(@PathVariable("id") Long id, @RequestBody CompatibilityAnswerUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/compatibility_answers/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
