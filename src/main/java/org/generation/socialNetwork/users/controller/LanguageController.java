package org.generation.socialNetwork.users.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.users.dto.LanguageCreateRequestDTO;
import org.generation.socialNetwork.users.dto.LanguageResponseDTO;
import org.generation.socialNetwork.users.dto.LanguageUpdateRequestDTO;
import org.generation.socialNetwork.users.service.LanguageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar Language.
 * Endpoint base: /api/languages
 */
@RestController
@RequestMapping("/api/languages")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService service;

    // Endpoint: POST /api/languages - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<LanguageResponseDTO> create(@RequestBody LanguageCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/languages - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<LanguageResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/languages/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<LanguageResponseDTO> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/languages/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<LanguageResponseDTO> update(@PathVariable("id") String id, @RequestBody LanguageUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/languages/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
