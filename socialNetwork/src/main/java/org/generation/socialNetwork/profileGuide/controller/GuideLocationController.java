package org.generation.socialNetwork.profileGuide.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.profileGuide.dto.GuideLocationCreateRequestDTO;
import org.generation.socialNetwork.profileGuide.dto.GuideLocationResponseDTO;
import org.generation.socialNetwork.profileGuide.dto.GuideLocationUpdateRequestDTO;
import org.generation.socialNetwork.profileGuide.service.GuideLocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guide_locations")
@RequiredArgsConstructor
public class GuideLocationController {

    private final GuideLocationService service;

    @PostMapping
    public ResponseEntity<GuideLocationResponseDTO> create(@RequestBody GuideLocationCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<GuideLocationResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuideLocationResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuideLocationResponseDTO> update(@PathVariable("id") Long id, @RequestBody GuideLocationUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}