package org.generation.socialNetwork.tours.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.tours.dto.TripBookingCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TripBookingResponseDTO;
import org.generation.socialNetwork.tours.dto.TripBookingUpdateRequestDTO;
import org.generation.socialNetwork.tours.service.TripBookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar TripBooking.
 * Endpoint base: /api/trip_bookings
 */
@RestController
@RequestMapping("/api/trip_bookings")
@RequiredArgsConstructor
public class TripBookingController {

    private final TripBookingService service;

    // Endpoint: POST /api/trip_bookings - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<TripBookingResponseDTO> create(@RequestBody TripBookingCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/trip_bookings - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<TripBookingResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/trip_bookings/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<TripBookingResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/trip_bookings/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<TripBookingResponseDTO> update(@PathVariable("id") Long id, @RequestBody TripBookingUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/trip_bookings/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
