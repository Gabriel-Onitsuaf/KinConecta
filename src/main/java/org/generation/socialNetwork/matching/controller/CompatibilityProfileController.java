package org.generation.socialNetwork.matching.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.matching.dto.CompatibilityProfileCreateRequestDTO;
import org.generation.socialNetwork.matching.dto.CompatibilityProfileResponseDTO;
import org.generation.socialNetwork.matching.dto.CompatibilityProfileUpdateRequestDTO;
import org.generation.socialNetwork.matching.service.CompatibilityProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar CompatibilityProfile.
 * Endpoint base: /api/compatibility_profiles
 */
@RestController
@RequestMapping("/api/compatibility_profiles")
@RequiredArgsConstructor
public class CompatibilityProfileController {

    private final CompatibilityProfileService service;

    // Endpoint: POST /api/compatibility_profiles - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<CompatibilityProfileResponseDTO> create(@RequestBody CompatibilityProfileCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/compatibility_profiles - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<CompatibilityProfileResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/compatibility_profiles/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<CompatibilityProfileResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/compatibility_profiles/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<CompatibilityProfileResponseDTO> update(@PathVariable("id") Long id, @RequestBody CompatibilityProfileUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/compatibility_profiles/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
