package org.generation.socialNetwork.profileTourist.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileLanguageCreateRequestDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileLanguageResponseDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileLanguageUpdateRequestDTO;
import org.generation.socialNetwork.profileTourist.model.TouristProfileLanguage;
import org.generation.socialNetwork.profileTourist.model.TouristProfileLanguageId;
import org.generation.socialNetwork.profileTourist.repository.TouristProfileLanguageRepository;
import org.generation.socialNetwork.profileTourist.repository.TouristProfileRepository;
import org.generation.socialNetwork.users.repository.LanguageRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TouristProfileLanguageServiceImpl implements TouristProfileLanguageService {

    private final TouristProfileLanguageRepository touristProfileLanguageRepository;
    private final TouristProfileRepository touristProfileRepository;
    private final LanguageRepository languageRepository;

    @Override
    public TouristProfileLanguageResponseDTO create(TouristProfileLanguageCreateRequestDTO dto) {
        validateTouristProfileExists(dto.getUserId(), "userId");
        validateLanguageExists(dto.getLanguageCode(), "languageCode");
        TouristProfileLanguage entity = TouristProfileLanguageMapper.toEntity(dto);
        return TouristProfileLanguageMapper.toResponseDTO(touristProfileLanguageRepository.save(entity));
    }

    @Override
    public TouristProfileLanguageResponseDTO update(Long userId, String languageCode, TouristProfileLanguageUpdateRequestDTO dto) {
        TouristProfileLanguageId id = new TouristProfileLanguageId(userId, languageCode);
        TouristProfileLanguage entity = touristProfileLanguageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TouristProfileLanguage not found with id: " + id));

        TouristProfileLanguageMapper.updateEntity(entity, dto);
        return TouristProfileLanguageMapper.toResponseDTO(touristProfileLanguageRepository.save(entity));
    }

    @Override
    public TouristProfileLanguageResponseDTO findById(Long userId, String languageCode) {
        TouristProfileLanguageId id = new TouristProfileLanguageId(userId, languageCode);
        return touristProfileLanguageRepository.findById(id)
                .map(TouristProfileLanguageMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("TouristProfileLanguage not found with id: " + id));
    }

    @Override
    public List<TouristProfileLanguageResponseDTO> findAll() {
        return touristProfileLanguageRepository.findAll().stream()
                .map(TouristProfileLanguageMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long userId, String languageCode) {
        TouristProfileLanguageId id = new TouristProfileLanguageId(userId, languageCode);
        if (!touristProfileLanguageRepository.existsById(id)) {
            throw new ResourceNotFoundException("TouristProfileLanguage not found with id: " + id);
        }
        touristProfileLanguageRepository.deleteById(id);
    }

    private void validateTouristProfileExists(Long id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!touristProfileRepository.existsById(id)) {
            throw new ResourceNotFoundException("TouristProfile not found for " + fieldName + ": " + id);
        }
    }
    private void validateLanguageExists(String id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!languageRepository.existsById(id)) {
            throw new ResourceNotFoundException("Language not found for " + fieldName + ": " + id);
        }
    }
}