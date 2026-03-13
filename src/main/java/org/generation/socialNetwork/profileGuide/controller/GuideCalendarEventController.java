package org.generation.socialNetwork.profileGuide.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.profileGuide.dto.GuideCalendarEventCreateRequestDTO;
import org.generation.socialNetwork.profileGuide.dto.GuideCalendarEventResponseDTO;
import org.generation.socialNetwork.profileGuide.dto.GuideCalendarEventUpdateRequestDTO;
import org.generation.socialNetwork.profileGuide.service.GuideCalendarEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar GuideCalendarEvent.
 * Endpoint base: /api/guide_calendar_events
 */
@RestController
@RequestMapping("/api/guide_calendar_events")
@RequiredArgsConstructor
public class GuideCalendarEventController {

    private final GuideCalendarEventService service;

    // Endpoint: POST /api/guide_calendar_events - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<GuideCalendarEventResponseDTO> create(@RequestBody GuideCalendarEventCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/guide_calendar_events - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<GuideCalendarEventResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/guide_calendar_events/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<GuideCalendarEventResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/guide_calendar_events/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<GuideCalendarEventResponseDTO> update(@PathVariable("id") Long id, @RequestBody GuideCalendarEventUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/guide_calendar_events/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
