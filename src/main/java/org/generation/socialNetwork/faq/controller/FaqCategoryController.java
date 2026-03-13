package org.generation.socialNetwork.faq.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.faq.dto.FaqCategoryCreateRequestDTO;
import org.generation.socialNetwork.faq.dto.FaqCategoryResponseDTO;
import org.generation.socialNetwork.faq.dto.FaqCategoryUpdateRequestDTO;
import org.generation.socialNetwork.faq.service.FaqCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar FaqCategory.
 * Endpoint base: /api/faq_categories
 */
@RestController
@RequestMapping("/api/faq_categories")
@RequiredArgsConstructor
public class FaqCategoryController {

    private final FaqCategoryService service;

    // Endpoint: POST /api/faq_categories - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<FaqCategoryResponseDTO> create(@RequestBody FaqCategoryCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/faq_categories - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<FaqCategoryResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/faq_categories/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<FaqCategoryResponseDTO> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/faq_categories/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<FaqCategoryResponseDTO> update(@PathVariable("id") Integer id, @RequestBody FaqCategoryUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/faq_categories/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
