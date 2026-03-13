package org.generation.socialNetwork.matching.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.matching.dto.CompatibilityAnswerCreateRequestDTO;
import org.generation.socialNetwork.matching.dto.CompatibilityAnswerResponseDTO;
import org.generation.socialNetwork.matching.dto.CompatibilityAnswerUpdateRequestDTO;
import org.generation.socialNetwork.matching.model.CompatibilityAnswer;
import org.generation.socialNetwork.matching.repository.CompatibilityAnswerRepository;
import org.generation.socialNetwork.matching.repository.CompatibilityProfileRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompatibilityAnswerServiceImpl implements CompatibilityAnswerService {

    private final CompatibilityAnswerRepository compatibilityAnswerRepository;
    private final CompatibilityProfileRepository compatibilityProfileRepository;

    @Override
    public CompatibilityAnswerResponseDTO create(CompatibilityAnswerCreateRequestDTO dto) {
        validateCompatibilityProfileExists(dto.getCompatibilityProfileId(), "compatibilityProfileId");
        CompatibilityAnswer entity = CompatibilityAnswerMapper.toEntity(dto);
        return CompatibilityAnswerMapper.toResponseDTO(compatibilityAnswerRepository.save(entity));
    }

    @Override
    public CompatibilityAnswerResponseDTO update(Long id, CompatibilityAnswerUpdateRequestDTO dto) {
        CompatibilityAnswer entity = compatibilityAnswerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CompatibilityAnswer not found with id: " + id));
        validateCompatibilityProfileExists(dto.getCompatibilityProfileId(), "compatibilityProfileId");
        CompatibilityAnswerMapper.updateEntity(entity, dto);
        return CompatibilityAnswerMapper.toResponseDTO(compatibilityAnswerRepository.save(entity));
    }

    @Override
    public CompatibilityAnswerResponseDTO findById(Long id) {
        return compatibilityAnswerRepository.findById(id)
                .map(CompatibilityAnswerMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("CompatibilityAnswer not found with id: " + id));
    }

    @Override
    public List<CompatibilityAnswerResponseDTO> findAll() {
        return compatibilityAnswerRepository.findAll().stream()
                .map(CompatibilityAnswerMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!compatibilityAnswerRepository.existsById(id)) {
            throw new ResourceNotFoundException("CompatibilityAnswer not found with id: " + id);
        }
        compatibilityAnswerRepository.deleteById(id);
    }

    private void validateCompatibilityProfileExists(Long id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!compatibilityProfileRepository.existsById(id)) {
            throw new ResourceNotFoundException("CompatibilityProfile not found for " + fieldName + ": " + id);
        }
    }
}