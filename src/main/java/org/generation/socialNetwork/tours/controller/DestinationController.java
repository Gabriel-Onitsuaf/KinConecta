package org.generation.socialNetwork.tours.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.tours.dto.DestinationCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.DestinationResponseDTO;
import org.generation.socialNetwork.tours.dto.DestinationUpdateRequestDTO;
import org.generation.socialNetwork.tours.service.DestinationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar Destination.
 * Endpoint base: /api/destinations
 */
@RestController
@RequestMapping("/api/destinations")
@RequiredArgsConstructor
public class DestinationController {

    private final DestinationService service;

    // Endpoint: POST /api/destinations - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<DestinationResponseDTO> create(@RequestBody DestinationCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/destinations - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<DestinationResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/destinations/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<DestinationResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/destinations/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<DestinationResponseDTO> update(@PathVariable("id") Long id, @RequestBody DestinationUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/destinations/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
