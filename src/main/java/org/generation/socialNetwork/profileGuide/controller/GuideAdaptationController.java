package org.generation.socialNetwork.profileGuide.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.profileGuide.dto.GuideAdaptationCreateRequestDTO;
import org.generation.socialNetwork.profileGuide.dto.GuideAdaptationResponseDTO;
import org.generation.socialNetwork.profileGuide.dto.GuideAdaptationUpdateRequestDTO;
import org.generation.socialNetwork.profileGuide.service.GuideAdaptationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar GuideAdaptation.
 * Endpoint base: /api/guide_adaptations
 */
@RestController
@RequestMapping("/api/guide_adaptations")
@RequiredArgsConstructor
public class GuideAdaptationController {

    private final GuideAdaptationService service;

    // Endpoint: POST /api/guide_adaptations - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<GuideAdaptationResponseDTO> create(@RequestBody GuideAdaptationCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/guide_adaptations - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<GuideAdaptationResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/guide_adaptations/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<GuideAdaptationResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/guide_adaptations/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<GuideAdaptationResponseDTO> update(@PathVariable("id") Long id, @RequestBody GuideAdaptationUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/guide_adaptations/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
