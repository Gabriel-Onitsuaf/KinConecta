package org.generation.socialNetwork.help.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.help.dto.SupportTicketCreateRequestDTO;
import org.generation.socialNetwork.help.dto.SupportTicketResponseDTO;
import org.generation.socialNetwork.help.dto.SupportTicketUpdateRequestDTO;
import org.generation.socialNetwork.help.service.SupportTicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar SupportTicket.
 * Endpoint base: /api/support_tickets
 */
@RestController
@RequestMapping("/api/support_tickets")
@RequiredArgsConstructor
public class SupportTicketController {

    private final SupportTicketService service;

    // Endpoint: POST /api/support_tickets - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<SupportTicketResponseDTO> create(@RequestBody SupportTicketCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/support_tickets - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<SupportTicketResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/support_tickets/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<SupportTicketResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/support_tickets/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<SupportTicketResponseDTO> update(@PathVariable("id") Long id, @RequestBody SupportTicketUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/support_tickets/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
