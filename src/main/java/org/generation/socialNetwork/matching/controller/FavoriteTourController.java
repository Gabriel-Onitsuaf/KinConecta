package org.generation.socialNetwork.matching.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.matching.dto.FavoriteTourCreateRequestDTO;
import org.generation.socialNetwork.matching.dto.FavoriteTourResponseDTO;
import org.generation.socialNetwork.matching.dto.FavoriteTourUpdateRequestDTO;
import org.generation.socialNetwork.matching.service.FavoriteTourService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar FavoriteTour.
 * Endpoint base: /api/favorite_tours
 */
@RestController
@RequestMapping("/api/favorite_tours")
@RequiredArgsConstructor
public class FavoriteTourController {

    private final FavoriteTourService service;

    // Endpoint: POST /api/favorite_tours - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<FavoriteTourResponseDTO> create(@RequestBody FavoriteTourCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/favorite_tours - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<FavoriteTourResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/favorite_tours/{touristId}/{tourId} - Obtiene un registro por identificador.
    @GetMapping("/{touristId}/{tourId}")
    public ResponseEntity<FavoriteTourResponseDTO> findById(@PathVariable Long touristId, @PathVariable Long tourId) {
        return ResponseEntity.ok(service.findById(touristId, tourId));
    }

    // Endpoint: PUT /api/favorite_tours/{touristId}/{tourId} - Actualiza un registro existente.
    @PutMapping("/{touristId}/{tourId}")
    public ResponseEntity<FavoriteTourResponseDTO> update(@PathVariable Long touristId, @PathVariable Long tourId, @RequestBody FavoriteTourUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(touristId, tourId, dto));
    }

    // Endpoint: DELETE /api/favorite_tours/{touristId}/{tourId} - Elimina un registro por identificador.
    @DeleteMapping("/{touristId}/{tourId}")
    public ResponseEntity<Void> delete(@PathVariable Long touristId, @PathVariable Long tourId) {
        service.delete(touristId, tourId);
        return ResponseEntity.noContent().build();
    }
}
