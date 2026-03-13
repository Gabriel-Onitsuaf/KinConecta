package org.generation.socialNetwork.profileGuide.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.profileGuide.dto.GuideProfileExpertiseCreateRequestDTO;
import org.generation.socialNetwork.profileGuide.dto.GuideProfileExpertiseResponseDTO;
import org.generation.socialNetwork.profileGuide.dto.GuideProfileExpertiseUpdateRequestDTO;
import org.generation.socialNetwork.profileGuide.service.GuideProfileExpertiseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar GuideProfileExpertise.
 * Endpoint base: /api/guide_profile_expertise
 */
@RestController
@RequestMapping("/api/guide_profile_expertise")
@RequiredArgsConstructor
public class GuideProfileExpertiseController {

    private final GuideProfileExpertiseService service;

    // Endpoint: POST /api/guide_profile_expertise - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<GuideProfileExpertiseResponseDTO> create(@RequestBody GuideProfileExpertiseCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/guide_profile_expertise - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<GuideProfileExpertiseResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/guide_profile_expertise/{userId}/{expertiseId} - Obtiene un registro por identificador.
    @GetMapping("/{userId}/{expertiseId}")
    public ResponseEntity<GuideProfileExpertiseResponseDTO> findById(@PathVariable Long userId, @PathVariable Integer expertiseId) {
        return ResponseEntity.ok(service.findById(userId, expertiseId));
    }

    // Endpoint: PUT /api/guide_profile_expertise/{userId}/{expertiseId} - Actualiza un registro existente.
    @PutMapping("/{userId}/{expertiseId}")
    public ResponseEntity<GuideProfileExpertiseResponseDTO> update(@PathVariable Long userId, @PathVariable Integer expertiseId, @RequestBody GuideProfileExpertiseUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(userId, expertiseId, dto));
    }

    // Endpoint: DELETE /api/guide_profile_expertise/{userId}/{expertiseId} - Elimina un registro por identificador.
    @DeleteMapping("/{userId}/{expertiseId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId, @PathVariable Integer expertiseId) {
        service.delete(userId, expertiseId);
        return ResponseEntity.noContent().build();
    }
}
