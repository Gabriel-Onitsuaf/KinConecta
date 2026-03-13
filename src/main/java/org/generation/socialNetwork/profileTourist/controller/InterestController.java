package org.generation.socialNetwork.profileTourist.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.profileTourist.dto.InterestCreateRequestDTO;
import org.generation.socialNetwork.profileTourist.dto.InterestResponseDTO;
import org.generation.socialNetwork.profileTourist.dto.InterestUpdateRequestDTO;
import org.generation.socialNetwork.profileTourist.service.InterestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar Interest.
 * Endpoint base: /api/interests
 */
@RestController
@RequestMapping("/api/interests")
@RequiredArgsConstructor
public class InterestController {

    private final InterestService service;

    // Endpoint: POST /api/interests - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<InterestResponseDTO> create(@RequestBody InterestCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/interests - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<InterestResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/interests/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<InterestResponseDTO> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/interests/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<InterestResponseDTO> update(@PathVariable("id") Integer id, @RequestBody InterestUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/interests/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
