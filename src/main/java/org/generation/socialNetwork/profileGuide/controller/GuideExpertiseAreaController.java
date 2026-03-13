package org.generation.socialNetwork.profileGuide.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.profileGuide.dto.GuideExpertiseAreaCreateRequestDTO;
import org.generation.socialNetwork.profileGuide.dto.GuideExpertiseAreaResponseDTO;
import org.generation.socialNetwork.profileGuide.dto.GuideExpertiseAreaUpdateRequestDTO;
import org.generation.socialNetwork.profileGuide.service.GuideExpertiseAreaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar GuideExpertiseArea.
 * Endpoint base: /api/guide_expertise_areas
 */
@RestController
@RequestMapping("/api/guide_expertise_areas")
@RequiredArgsConstructor
public class GuideExpertiseAreaController {

    private final GuideExpertiseAreaService service;

    // Endpoint: POST /api/guide_expertise_areas - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<GuideExpertiseAreaResponseDTO> create(@RequestBody GuideExpertiseAreaCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/guide_expertise_areas - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<GuideExpertiseAreaResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/guide_expertise_areas/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<GuideExpertiseAreaResponseDTO> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/guide_expertise_areas/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<GuideExpertiseAreaResponseDTO> update(@PathVariable("id") Integer id, @RequestBody GuideExpertiseAreaUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/guide_expertise_areas/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
