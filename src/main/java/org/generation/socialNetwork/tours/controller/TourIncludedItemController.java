package org.generation.socialNetwork.tours.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.tours.dto.TourIncludedItemCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TourIncludedItemResponseDTO;
import org.generation.socialNetwork.tours.dto.TourIncludedItemUpdateRequestDTO;
import org.generation.socialNetwork.tours.service.TourIncludedItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar TourIncludedItem.
 * Endpoint base: /api/tour_included_items
 */
@RestController
@RequestMapping("/api/tour_included_items")
@RequiredArgsConstructor
public class TourIncludedItemController {

    private final TourIncludedItemService service;

    // Endpoint: POST /api/tour_included_items - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<TourIncludedItemResponseDTO> create(@RequestBody TourIncludedItemCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/tour_included_items - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<TourIncludedItemResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/tour_included_items/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<TourIncludedItemResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/tour_included_items/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<TourIncludedItemResponseDTO> update(@PathVariable("id") Long id, @RequestBody TourIncludedItemUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/tour_included_items/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
