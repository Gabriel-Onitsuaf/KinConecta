package org.generation.socialNetwork.tours.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.tours.dto.TourCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TourResponseDTO;
import org.generation.socialNetwork.tours.dto.TourUpdateRequestDTO;
import org.generation.socialNetwork.tours.service.TourService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar Tour.
 * Endpoint base: /api/tours
 */
@RestController
@RequestMapping("/api/tours")
@RequiredArgsConstructor
public class TourController {

    private final TourService service;

    // Endpoint: POST /api/tours - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<TourResponseDTO> create(@RequestBody TourCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/tours - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<TourResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/tours/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<TourResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/tours/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<TourResponseDTO> update(@PathVariable("id") Long id, @RequestBody TourUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/tours/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
