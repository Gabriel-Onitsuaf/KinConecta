package org.generation.socialNetwork.contact.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.contact.dto.NewsletterSubscriptionCreateRequestDTO;
import org.generation.socialNetwork.contact.dto.NewsletterSubscriptionResponseDTO;
import org.generation.socialNetwork.contact.dto.NewsletterSubscriptionUpdateRequestDTO;
import org.generation.socialNetwork.contact.service.NewsletterSubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar NewsletterSubscription.
 * Endpoint base: /api/newsletter_subscriptions
 */
@RestController
@RequestMapping("/api/newsletter_subscriptions")
@RequiredArgsConstructor
public class NewsletterSubscriptionController {

    private final NewsletterSubscriptionService service;

    // Endpoint: POST /api/newsletter_subscriptions - Crea un nuevo registro.
    @PostMapping
    public ResponseEntity<NewsletterSubscriptionResponseDTO> create(@RequestBody NewsletterSubscriptionCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    // Endpoint: GET /api/newsletter_subscriptions - Obtiene todos los registros.
    @GetMapping
    public ResponseEntity<List<NewsletterSubscriptionResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint: GET /api/newsletter_subscriptions/{id} - Obtiene un registro por identificador.
    @GetMapping("/{id}")
    public ResponseEntity<NewsletterSubscriptionResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint: PUT /api/newsletter_subscriptions/{id} - Actualiza un registro existente.
    @PutMapping("/{id}")
    public ResponseEntity<NewsletterSubscriptionResponseDTO> update(@PathVariable("id") Long id, @RequestBody NewsletterSubscriptionUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Endpoint: DELETE /api/newsletter_subscriptions/{id} - Elimina un registro por identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
