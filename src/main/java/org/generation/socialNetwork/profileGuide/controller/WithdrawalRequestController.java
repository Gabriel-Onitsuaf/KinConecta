package org.generation.socialNetwork.profileGuide.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.profileGuide.dto.WithdrawalRequestCreateRequestDTO;
import org.generation.socialNetwork.profileGuide.dto.WithdrawalRequestResponseDTO;
import org.generation.socialNetwork.profileGuide.dto.WithdrawalRequestUpdateRequestDTO;
import org.generation.socialNetwork.profileGuide.service.WithdrawalRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar WithdrawalRequest.
 * Endpoint base: /api/withdrawal_requests
 */
@RestController
@RequestMapping("/api/withdrawal_requests")
@RequiredArgsConstructor
public class WithdrawalRequestController {

    private final WithdrawalRequestService service;

    // Endpoint: POST /api/withdrawal_requests - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<WithdrawalRequestResponseDTO> create(@RequestBody WithdrawalRequestCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/withdrawal_requests - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<WithdrawalRequestResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/withdrawal_requests/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<WithdrawalRequestResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/withdrawal_requests/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<WithdrawalRequestResponseDTO> update(@PathVariable("id") Long id, @RequestBody WithdrawalRequestUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/withdrawal_requests/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
