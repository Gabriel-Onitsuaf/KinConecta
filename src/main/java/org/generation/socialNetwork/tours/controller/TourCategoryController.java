package org.generation.socialNetwork.tours.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.tours.dto.TourCategoryCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TourCategoryResponseDTO;
import org.generation.socialNetwork.tours.dto.TourCategoryUpdateRequestDTO;
import org.generation.socialNetwork.tours.service.TourCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar TourCategory.
 * Endpoint base: /api/tour_categories
 */
@RestController
@RequestMapping("/api/tour_categories")
@RequiredArgsConstructor
public class TourCategoryController {

    private final TourCategoryService service;

    // Endpoint: POST /api/tour_categories - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<TourCategoryResponseDTO> create(@RequestBody TourCategoryCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/tour_categories - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<TourCategoryResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/tour_categories/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<TourCategoryResponseDTO> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/tour_categories/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<TourCategoryResponseDTO> update(@PathVariable("id") Integer id, @RequestBody TourCategoryUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/tour_categories/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
