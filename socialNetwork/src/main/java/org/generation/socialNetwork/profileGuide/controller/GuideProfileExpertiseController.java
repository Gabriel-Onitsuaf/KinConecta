package org.generation.socialNetwork.profileGuide.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.profileGuide.dto.GuideProfileExpertiseCreateRequestDTO;
import org.generation.socialNetwork.profileGuide.dto.GuideProfileExpertiseResponseDTO;
import org.generation.socialNetwork.profileGuide.dto.GuideProfileExpertiseUpdateRequestDTO;
import org.generation.socialNetwork.profileGuide.service.GuideProfileExpertiseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guide_profile_expertise")
@RequiredArgsConstructor
public class GuideProfileExpertiseController {

    private final GuideProfileExpertiseService service;

    @PostMapping
    public ResponseEntity<GuideProfileExpertiseResponseDTO> create(@RequestBody GuideProfileExpertiseCreateRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<GuideProfileExpertiseResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{userId}/{expertiseId}")
    public ResponseEntity<GuideProfileExpertiseResponseDTO> findById(@PathVariable Long userId, @PathVariable Integer expertiseId) {
        return ResponseEntity.ok(service.findById(userId, expertiseId));
    }

    @PutMapping("/{userId}/{expertiseId}")
    public ResponseEntity<GuideProfileExpertiseResponseDTO> update(@PathVariable Long userId, @PathVariable Integer expertiseId, @RequestBody GuideProfileExpertiseUpdateRequestDTO dto) {
        return ResponseEntity.ok(service.update(userId, expertiseId, dto));
    }

    @DeleteMapping("/{userId}/{expertiseId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId, @PathVariable Integer expertiseId) {
        service.delete(userId, expertiseId);
        return ResponseEntity.noContent().build();
    }
}