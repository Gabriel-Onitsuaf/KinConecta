package org.generation.socialNetwork.profileTourist.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileCreateRequestDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileResponseDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileUpdateRequestDTO;
import org.generation.socialNetwork.profileTourist.model.TouristProfile;
import org.generation.socialNetwork.profileTourist.repository.TouristProfileRepository;
import org.generation.socialNetwork.users.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TouristProfileServiceImpl implements TouristProfileService {

    private final TouristProfileRepository touristProfileRepository;
    private final UserRepository userRepository;

    @Override
    public TouristProfileResponseDTO create(TouristProfileCreateRequestDTO dto) {
        validateUserExists(dto.getUserId(), "userId");
        TouristProfile entity = TouristProfileMapper.toEntity(dto);
        return TouristProfileMapper.toResponseDTO(touristProfileRepository.save(entity));
    }

    @Override
    public TouristProfileResponseDTO update(Long id, TouristProfileUpdateRequestDTO dto) {
        TouristProfile entity = touristProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TouristProfile not found with id: " + id));

        TouristProfileMapper.updateEntity(entity, dto);
        return TouristProfileMapper.toResponseDTO(touristProfileRepository.save(entity));
    }

    @Override
    public TouristProfileResponseDTO findById(Long id) {
        return touristProfileRepository.findById(id)
                .map(TouristProfileMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("TouristProfile not found with id: " + id));
    }

    @Override
    public List<TouristProfileResponseDTO> findAll() {
        return touristProfileRepository.findAll().stream()
                .map(TouristProfileMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!touristProfileRepository.existsById(id)) {
            throw new ResourceNotFoundException("TouristProfile not found with id: " + id);
        }
        touristProfileRepository.deleteById(id);
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