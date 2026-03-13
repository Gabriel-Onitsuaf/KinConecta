package org.generation.socialNetwork.profileGuide.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.profileGuide.dto.GuideProfileCreateRequestDTO;
import org.generation.socialNetwork.profileGuide.dto.GuideProfileResponseDTO;
import org.generation.socialNetwork.profileGuide.dto.GuideProfileUpdateRequestDTO;
import org.generation.socialNetwork.profileGuide.service.GuideProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar GuideProfile.
 * Endpoint base: /api/guide_profiles
 */
@RestController
@RequestMapping("/api/guide_profiles")
@RequiredArgsConstructor
public class GuideProfileController {

    private final GuideProfileService service;

    // Endpoint: POST /api/guide_profiles - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<GuideProfileResponseDTO> create(@RequestBody GuideProfileCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/guide_profiles - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<GuideProfileResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/guide_profiles/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<GuideProfileResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/guide_profiles/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<GuideProfileResponseDTO> update(@PathVariable("id") Long id, @RequestBody GuideProfileUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/guide_profiles/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
