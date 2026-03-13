package org.generation.socialNetwork.profileTourist.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileCreateRequestDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileResponseDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileUpdateRequestDTO;
import org.generation.socialNetwork.profileTourist.service.TouristProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar TouristProfile.
 * Endpoint base: /api/tourist_profiles
 */
@RestController
@RequestMapping("/api/tourist_profiles")
@RequiredArgsConstructor
public class TouristProfileController {

    private final TouristProfileService service;

    // Endpoint: POST /api/tourist_profiles - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<TouristProfileResponseDTO> create(@RequestBody TouristProfileCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/tourist_profiles - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<TouristProfileResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/tourist_profiles/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<TouristProfileResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/tourist_profiles/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<TouristProfileResponseDTO> update(@PathVariable("id") Long id, @RequestBody TouristProfileUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/tourist_profiles/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
