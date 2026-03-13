package org.generation.socialNetwork.faq.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.faq.dto.FaqItemCreateRequestDTO;
import org.generation.socialNetwork.faq.dto.FaqItemResponseDTO;
import org.generation.socialNetwork.faq.dto.FaqItemUpdateRequestDTO;
import org.generation.socialNetwork.faq.service.FaqItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar FaqItem.
 * Endpoint base: /api/faq_items
 */
@RestController
@RequestMapping("/api/faq_items")
@RequiredArgsConstructor
public class FaqItemController {

    private final FaqItemService service;

    // Endpoint: POST /api/faq_items - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<FaqItemResponseDTO> create(@RequestBody FaqItemCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/faq_items - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<FaqItemResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/faq_items/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<FaqItemResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/faq_items/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<FaqItemResponseDTO> update(@PathVariable("id") Long id, @RequestBody FaqItemUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/faq_items/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
