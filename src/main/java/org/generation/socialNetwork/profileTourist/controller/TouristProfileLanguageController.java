package org.generation.socialNetwork.profileTourist.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileLanguageCreateRequestDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileLanguageResponseDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileLanguageUpdateRequestDTO;
import org.generation.socialNetwork.profileTourist.service.TouristProfileLanguageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar TouristProfileLanguage.
 * Endpoint base: /api/tourist_profile_languages
 */
@RestController
@RequestMapping("/api/tourist_profile_languages")
@RequiredArgsConstructor
public class TouristProfileLanguageController {

    private final TouristProfileLanguageService service;

    // Endpoint: POST /api/tourist_profile_languages - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<TouristProfileLanguageResponseDTO> create(@RequestBody TouristProfileLanguageCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/tourist_profile_languages - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<TouristProfileLanguageResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/tourist_profile_languages/{userId}/{languageCode} - Obtiene un registro por identificador.
    @GetMapping("/{userId}/{languageCode}")
    public ResponseEntity<TouristProfileLanguageResponseDTO> findById(@PathVariable Long userId, @PathVariable String languageCode) {
        return ResponseEntity.ok(service.findById(userId, languageCode));
    }

    // Endpoint: PUT /api/tourist_profile_languages/{userId}/{languageCode} - Actualiza un registro existente.
    @PutMapping("/{userId}/{languageCode}")
    public ResponseEntity<TouristProfileLanguageResponseDTO> update(@PathVariable Long userId, @PathVariable String languageCode, @RequestBody TouristProfileLanguageUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(userId, languageCode, dto));
    }

    // Endpoint: DELETE /api/tourist_profile_languages/{userId}/{languageCode} - Elimina un registro por identificador.
    @DeleteMapping("/{userId}/{languageCode}")
    public ResponseEntity<Void> delete(@PathVariable Long userId, @PathVariable String languageCode) {
        service.delete(userId, languageCode);
        return ResponseEntity.noContent().build();
    }
}
