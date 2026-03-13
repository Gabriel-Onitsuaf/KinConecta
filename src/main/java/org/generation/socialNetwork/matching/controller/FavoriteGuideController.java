package org.generation.socialNetwork.matching.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.matching.dto.FavoriteGuideCreateRequestDTO;
import org.generation.socialNetwork.matching.dto.FavoriteGuideResponseDTO;
import org.generation.socialNetwork.matching.dto.FavoriteGuideUpdateRequestDTO;
import org.generation.socialNetwork.matching.service.FavoriteGuideService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar FavoriteGuide.
 * Endpoint base: /api/favorite_guides
 */
@RestController
@RequestMapping("/api/favorite_guides")
@RequiredArgsConstructor
public class FavoriteGuideController {

    private final FavoriteGuideService service;

    // Endpoint: POST /api/favorite_guides - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<FavoriteGuideResponseDTO> create(@RequestBody FavoriteGuideCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/favorite_guides - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<FavoriteGuideResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/favorite_guides/{touristId}/{guideId} - Obtiene un registro por identificador.
    @GetMapping("/{touristId}/{guideId}")
    public ResponseEntity<FavoriteGuideResponseDTO> findById(@PathVariable Long touristId, @PathVariable Long guideId) {
        return ResponseEntity.ok(service.findById(touristId, guideId));
    }

    // Endpoint: PUT /api/favorite_guides/{touristId}/{guideId} - Actualiza un registro existente.
    @PutMapping("/{touristId}/{guideId}")
    public ResponseEntity<FavoriteGuideResponseDTO> update(@PathVariable Long touristId, @PathVariable Long guideId, @RequestBody FavoriteGuideUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(touristId, guideId, dto));
    }

    // Endpoint: DELETE /api/favorite_guides/{touristId}/{guideId} - Elimina un registro por identificador.
    @DeleteMapping("/{touristId}/{guideId}")
    public ResponseEntity<Void> delete(@PathVariable Long touristId, @PathVariable Long guideId) {
        service.delete(touristId, guideId);
        return ResponseEntity.noContent().build();
    }
}
