package org.generation.socialNetwork.profileTourist.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileInterestCreateRequestDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileInterestResponseDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileInterestUpdateRequestDTO;
import org.generation.socialNetwork.profileTourist.model.TouristProfileInterest;
import org.generation.socialNetwork.profileTourist.model.TouristProfileInterestId;
import org.generation.socialNetwork.profileTourist.repository.InterestRepository;
import org.generation.socialNetwork.profileTourist.repository.TouristProfileInterestRepository;
import org.generation.socialNetwork.profileTourist.repository.TouristProfileRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TouristProfileInterestServiceImpl implements TouristProfileInterestService {

    private final TouristProfileInterestRepository touristProfileInterestRepository;
    private final TouristProfileRepository touristProfileRepository;
    private final InterestRepository interestRepository;

    @Override
    public TouristProfileInterestResponseDTO create(TouristProfileInterestCreateRequestDTO dto) {
        validateTouristProfileExists(dto.getUserId(), "userId");
        validateInterestExists(dto.getInterestId(), "interestId");
        TouristProfileInterest entity = TouristProfileInterestMapper.toEntity(dto);
        return TouristProfileInterestMapper.toResponseDTO(touristProfileInterestRepository.save(entity));
    }

    @Override
    public TouristProfileInterestResponseDTO update(Long userId, Integer interestId, TouristProfileInterestUpdateRequestDTO dto) {
        TouristProfileInterestId id = new TouristProfileInterestId(userId, interestId);
        TouristProfileInterest entity = touristProfileInterestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TouristProfileInterest not found with id: " + id));

        TouristProfileInterestMapper.updateEntity(entity, dto);
        return TouristProfileInterestMapper.toResponseDTO(touristProfileInterestRepository.save(entity));
    }

    @Override
    public TouristProfileInterestResponseDTO findById(Long userId, Integer interestId) {
        TouristProfileInterestId id = new TouristProfileInterestId(userId, interestId);
        return touristProfileInterestRepository.findById(id)
                .map(TouristProfileInterestMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("TouristProfileInterest not found with id: " + id));
    }

    @Override
    public List<TouristProfileInterestResponseDTO> findAll() {
        return touristProfileInterestRepository.findAll().stream()
                .map(TouristProfileInterestMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long userId, Integer interestId) {
        TouristProfileInterestId id = new TouristProfileInterestId(userId, interestId);
        if (!touristProfileInterestRepository.existsById(id)) {
            throw new ResourceNotFoundException("TouristProfileInterest not found with id: " + id);
        }
        touristProfileInterestRepository.deleteById(id);
    }

    private void validateTouristProfileExists(Long id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!touristProfileRepository.existsById(id)) {
            throw new ResourceNotFoundException("TouristProfile not found for " + fieldName + ": " + id);
        }
    }
    private void validateInterestExists(Integer id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!interestRepository.existsById(id)) {
            throw new ResourceNotFoundException("Interest not found for " + fieldName + ": " + id);
        }
    }
}