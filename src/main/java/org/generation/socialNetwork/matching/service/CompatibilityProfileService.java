package org.generation.socialNetwork.matching.service;

import org.generation.socialNetwork.matching.dto.CompatibilityProfileCreateRequestDTO;
import org.generation.socialNetwork.matching.dto.CompatibilityProfileResponseDTO;
import org.generation.socialNetwork.matching.dto.CompatibilityProfileUpdateRequestDTO;

import java.util.List;

public interface CompatibilityProfileService {

    CompatibilityProfileResponseDTO create(CompatibilityProfileCreateRequestDTO dto);

    CompatibilityProfileResponseDTO update(Long id, CompatibilityProfileUpdateRequestDTO dto);

    CompatibilityProfileResponseDTO findById(Long id);

    List<CompatibilityProfileResponseDTO> findAll();

    void delete(Long id);
}