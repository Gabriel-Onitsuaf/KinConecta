package org.generation.socialNetwork.help.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.help.dto.SupportTicketAttachmentCreateRequestDTO;
import org.generation.socialNetwork.help.dto.SupportTicketAttachmentResponseDTO;
import org.generation.socialNetwork.help.dto.SupportTicketAttachmentUpdateRequestDTO;
import org.generation.socialNetwork.help.service.SupportTicketAttachmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar SupportTicketAttachment.
 * Endpoint base: /api/support_ticket_attachments
 */
@RestController
@RequestMapping("/api/support_ticket_attachments")
@RequiredArgsConstructor
public class SupportTicketAttachmentController {

    private final SupportTicketAttachmentService service;

    // Endpoint: POST /api/support_ticket_attachments - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<SupportTicketAttachmentResponseDTO> create(@RequestBody SupportTicketAttachmentCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/support_ticket_attachments - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<SupportTicketAttachmentResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/support_ticket_attachments/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<SupportTicketAttachmentResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/support_ticket_attachments/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<SupportTicketAttachmentResponseDTO> update(@PathVariable("id") Long id, @RequestBody SupportTicketAttachmentUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/support_ticket_attachments/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
