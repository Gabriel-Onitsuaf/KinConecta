package org.generation.socialNetwork.profileGuide.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.profileGuide.dto.GuideCertificationCreateRequestDTO;
import org.generation.socialNetwork.profileGuide.dto.GuideCertificationResponseDTO;
import org.generation.socialNetwork.profileGuide.dto.GuideCertificationUpdateRequestDTO;
import org.generation.socialNetwork.profileGuide.service.GuideCertificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guide_certifications")
@RequiredArgsConstructor
public class GuideCertificationController {

    private final GuideCertificationService service;

    @PostMapping
    public ResponseEntity<GuideCertificationResponseDTO> create(@RequestBody GuideCertificationCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<GuideCertificationResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuideCertificationResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuideCertificationResponseDTO> update(@PathVariable("id") Long id, @RequestBody GuideCertificationUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}