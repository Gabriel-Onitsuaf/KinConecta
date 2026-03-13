package org.generation.socialNetwork.profileTourist.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileInterestCreateRequestDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileInterestResponseDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileInterestUpdateRequestDTO;
import org.generation.socialNetwork.profileTourist.service.TouristProfileInterestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar TouristProfileInterest.
 * Endpoint base: /api/tourist_profile_interests
 */
@RestController
@RequestMapping("/api/tourist_profile_interests")
@RequiredArgsConstructor
public class TouristProfileInterestController {

    private final TouristProfileInterestService service;

    // Endpoint: POST /api/tourist_profile_interests - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<TouristProfileInterestResponseDTO> create(@RequestBody TouristProfileInterestCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/tourist_profile_interests - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<TouristProfileInterestResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/tourist_profile_interests/{userId}/{interestId} - Obtiene un registro por identificador.
    @GetMapping("/{userId}/{interestId}")
    public ResponseEntity<TouristProfileInterestResponseDTO> findById(@PathVariable Long userId, @PathVariable Integer interestId) {
        return ResponseEntity.ok(service.findById(userId, interestId));
    }

    // Endpoint: PUT /api/tourist_profile_interests/{userId}/{interestId} - Actualiza un registro existente.
    @PutMapping("/{userId}/{interestId}")
    public ResponseEntity<TouristProfileInterestResponseDTO> update(@PathVariable Long userId, @PathVariable Integer interestId, @RequestBody TouristProfileInterestUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(userId, interestId, dto));
    }

    // Endpoint: DELETE /api/tourist_profile_interests/{userId}/{interestId} - Elimina un registro por identificador.
    @DeleteMapping("/{userId}/{interestId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId, @PathVariable Integer interestId) {
        service.delete(userId, interestId);
        return ResponseEntity.noContent().build();
    }
}
