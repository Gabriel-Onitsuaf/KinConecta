package org.generation.socialNetwork.matching.service;

import org.generation.socialNetwork.matching.dto.CompatibilityAnswerCreateRequestDTO;
import org.generation.socialNetwork.matching.dto.CompatibilityAnswerResponseDTO;
import org.generation.socialNetwork.matching.dto.CompatibilityAnswerUpdateRequestDTO;

import java.util.List;

public interface CompatibilityAnswerService {

    CompatibilityAnswerResponseDTO create(CompatibilityAnswerCreateRequestDTO dto);

    CompatibilityAnswerResponseDTO update(Long id, CompatibilityAnswerUpdateRequestDTO dto);

    CompatibilityAnswerResponseDTO findById(Long id);

    List<CompatibilityAnswerResponseDTO> findAll();

    void delete(Long id);
}