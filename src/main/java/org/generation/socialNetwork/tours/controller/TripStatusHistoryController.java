package org.generation.socialNetwork.tours.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.tours.dto.TripStatusHistoryCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TripStatusHistoryResponseDTO;
import org.generation.socialNetwork.tours.dto.TripStatusHistoryUpdateRequestDTO;
import org.generation.socialNetwork.tours.service.TripStatusHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar TripStatusHistory.
 * Endpoint base: /api/trip_status_history
 */
@RestController
@RequestMapping("/api/trip_status_history")
@RequiredArgsConstructor
public class TripStatusHistoryController {

    private final TripStatusHistoryService service;

    // Endpoint: POST /api/trip_status_history - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<TripStatusHistoryResponseDTO> create(@RequestBody TripStatusHistoryCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/trip_status_history - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<TripStatusHistoryResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/trip_status_history/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<TripStatusHistoryResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/trip_status_history/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<TripStatusHistoryResponseDTO> update(@PathVariable("id") Long id, @RequestBody TripStatusHistoryUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/trip_status_history/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
