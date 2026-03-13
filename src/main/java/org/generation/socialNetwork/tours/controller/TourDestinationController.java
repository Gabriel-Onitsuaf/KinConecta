package org.generation.socialNetwork.tours.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.tours.dto.TourDestinationCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TourDestinationResponseDTO;
import org.generation.socialNetwork.tours.dto.TourDestinationUpdateRequestDTO;
import org.generation.socialNetwork.tours.service.TourDestinationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar TourDestination.
 * Endpoint base: /api/tour_destinations
 */
@RestController
@RequestMapping("/api/tour_destinations")
@RequiredArgsConstructor
public class TourDestinationController {

    private final TourDestinationService service;

    // Endpoint: POST /api/tour_destinations - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<TourDestinationResponseDTO> create(@RequestBody TourDestinationCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/tour_destinations - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<TourDestinationResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/tour_destinations/{tourId}/{destinationId} - Obtiene un registro por identificador.
    @GetMapping("/{tourId}/{destinationId}")
    public ResponseEntity<TourDestinationResponseDTO> findById(@PathVariable Long tourId, @PathVariable Long destinationId) {
        return ResponseEntity.ok(service.findById(tourId, destinationId));
    }

    // Endpoint: PUT /api/tour_destinations/{tourId}/{destinationId} - Actualiza un registro existente.
    @PutMapping("/{tourId}/{destinationId}")
    public ResponseEntity<TourDestinationResponseDTO> update(@PathVariable Long tourId, @PathVariable Long destinationId, @RequestBody TourDestinationUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(tourId, destinationId, dto));
    }

    // Endpoint: DELETE /api/tour_destinations/{tourId}/{destinationId} - Elimina un registro por identificador.
    @DeleteMapping("/{tourId}/{destinationId}")
    public ResponseEntity<Void> delete(@PathVariable Long tourId, @PathVariable Long destinationId) {
        service.delete(tourId, destinationId);
        return ResponseEntity.noContent().build();
    }
}
