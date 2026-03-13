package org.generation.socialNetwork.matching.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.matching.dto.CompatibilityProfileCreateRequestDTO;
import org.generation.socialNetwork.matching.dto.CompatibilityProfileResponseDTO;
import org.generation.socialNetwork.matching.dto.CompatibilityProfileUpdateRequestDTO;
import org.generation.socialNetwork.matching.model.CompatibilityProfile;
import org.generation.socialNetwork.matching.repository.CompatibilityProfileRepository;
import org.generation.socialNetwork.users.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompatibilityProfileServiceImpl implements CompatibilityProfileService {

    private final CompatibilityProfileRepository compatibilityProfileRepository;
    private final UserRepository userRepository;

    @Override
    public CompatibilityProfileResponseDTO create(CompatibilityProfileCreateRequestDTO dto) {
        validateUserExists(dto.getUserId(), "userId");
        CompatibilityProfile entity = CompatibilityProfileMapper.toEntity(dto);
        return CompatibilityProfileMapper.toResponseDTO(compatibilityProfileRepository.save(entity));
    }

    @Override
    public CompatibilityProfileResponseDTO update(Long id, CompatibilityProfileUpdateRequestDTO dto) {
        CompatibilityProfile entity = compatibilityProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CompatibilityProfile not found with id: " + id));
        validateUserExists(dto.getUserId(), "userId");
        CompatibilityProfileMapper.updateEntity(entity, dto);
        return CompatibilityProfileMapper.toResponseDTO(compatibilityProfileRepository.save(entity));
    }

    @Override
    public CompatibilityProfileResponseDTO findById(Long id) {
        return compatibilityProfileRepository.findById(id)
                .map(CompatibilityProfileMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("CompatibilityProfile not found with id: " + id));
    }

    @Override
    public List<CompatibilityProfileResponseDTO> findAll() {
        return compatibilityProfileRepository.findAll().stream()
                .map(CompatibilityProfileMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!compatibilityProfileRepository.existsById(id)) {
            throw new ResourceNotFoundException("CompatibilityProfile not found with id: " + id);
        }
        compatibilityProfileRepository.deleteById(id);
    }

    private void validateUserExists(Long id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found for " + fieldName + ": " + id);
        }
    }
}