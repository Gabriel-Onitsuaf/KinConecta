package org.generation.socialNetwork.profileGuide.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.profileGuide.dto.IncomeTransactionCreateRequestDTO;
import org.generation.socialNetwork.profileGuide.dto.IncomeTransactionResponseDTO;
import org.generation.socialNetwork.profileGuide.dto.IncomeTransactionUpdateRequestDTO;
import org.generation.socialNetwork.profileGuide.service.IncomeTransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar IncomeTransaction.
 * Endpoint base: /api/income_transactions
 */
@RestController
@RequestMapping("/api/income_transactions")
@RequiredArgsConstructor
public class IncomeTransactionController {

    private final IncomeTransactionService service;

    // Endpoint: POST /api/income_transactions - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<IncomeTransactionResponseDTO> create(@RequestBody IncomeTransactionCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/income_transactions - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<IncomeTransactionResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/income_transactions/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<IncomeTransactionResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/income_transactions/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<IncomeTransactionResponseDTO> update(@PathVariable("id") Long id, @RequestBody IncomeTransactionUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/income_transactions/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
