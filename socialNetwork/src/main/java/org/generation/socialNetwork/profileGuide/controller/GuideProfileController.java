package org.generation.socialNetwork.profileGuide.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.profileGuide.dto.GuideProfileCreateRequestDTO;
import org.generation.socialNetwork.profileGuide.dto.GuideProfileResponseDTO;
import org.generation.socialNetwork.profileGuide.dto.GuideProfileUpdateRequestDTO;
import org.generation.socialNetwork.profileGuide.service.GuideProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guide_profiles")
@RequiredArgsConstructor
public class GuideProfileController {

    private final GuideProfileService service;

    @PostMapping
    public ResponseEntity<GuideProfileResponseDTO> create(@RequestBody GuideProfileCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<GuideProfileResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuideProfileResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuideProfileResponseDTO> update(@PathVariable("id") Long id, @RequestBody GuideProfileUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}