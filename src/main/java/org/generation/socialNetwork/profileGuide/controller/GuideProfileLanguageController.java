package org.generation.socialNetwork.profileGuide.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.profileGuide.dto.GuideProfileLanguageCreateRequestDTO;
import org.generation.socialNetwork.profileGuide.dto.GuideProfileLanguageResponseDTO;
import org.generation.socialNetwork.profileGuide.dto.GuideProfileLanguageUpdateRequestDTO;
import org.generation.socialNetwork.profileGuide.service.GuideProfileLanguageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar GuideProfileLanguage.
 * Endpoint base: /api/guide_profile_languages
 */
@RestController
@RequestMapping("/api/guide_profile_languages")
@RequiredArgsConstructor
public class GuideProfileLanguageController {

    private final GuideProfileLanguageService service;

    // Endpoint: POST /api/guide_profile_languages - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<GuideProfileLanguageResponseDTO> create(@RequestBody GuideProfileLanguageCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/guide_profile_languages - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<GuideProfileLanguageResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/guide_profile_languages/{userId}/{languageCode} - Obtiene un registro por identificador.
    @GetMapping("/{userId}/{languageCode}")
    public ResponseEntity<GuideProfileLanguageResponseDTO> findById(@PathVariable Long userId, @PathVariable String languageCode) {
        return ResponseEntity.ok(service.findById(userId, languageCode));
    }

    // Endpoint: PUT /api/guide_profile_languages/{userId}/{languageCode} - Actualiza un registro existente.
    @PutMapping("/{userId}/{languageCode}")
    public ResponseEntity<GuideProfileLanguageResponseDTO> update(@PathVariable Long userId, @PathVariable String languageCode, @RequestBody GuideProfileLanguageUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(userId, languageCode, dto));
    }

    // Endpoint: DELETE /api/guide_profile_languages/{userId}/{languageCode} - Elimina un registro por identificador.
    @DeleteMapping("/{userId}/{languageCode}")
    public ResponseEntity<Void> delete(@PathVariable Long userId, @PathVariable String languageCode) {
        service.delete(userId, languageCode);
        return ResponseEntity.noContent().build();
    }
}
