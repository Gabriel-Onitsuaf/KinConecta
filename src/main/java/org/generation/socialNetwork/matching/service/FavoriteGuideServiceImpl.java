package org.generation.socialNetwork.matching.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.matching.dto.FavoriteGuideCreateRequestDTO;
import org.generation.socialNetwork.matching.dto.FavoriteGuideResponseDTO;
import org.generation.socialNetwork.matching.dto.FavoriteGuideUpdateRequestDTO;
import org.generation.socialNetwork.matching.model.FavoriteGuide;
import org.generation.socialNetwork.matching.model.FavoriteGuideId;
import org.generation.socialNetwork.matching.repository.FavoriteGuideRepository;
import org.generation.socialNetwork.users.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavoriteGuideServiceImpl implements FavoriteGuideService {

    private final FavoriteGuideRepository favoriteGuideRepository;
    private final UserRepository userRepository;

    @Override
    public FavoriteGuideResponseDTO create(FavoriteGuideCreateRequestDTO dto) {
        validateUserExists(dto.getTouristId(), "touristId");
        validateUserExists(dto.getGuideId(), "guideId");
        FavoriteGuide entity = FavoriteGuideMapper.toEntity(dto);
        return FavoriteGuideMapper.toResponseDTO(favoriteGuideRepository.save(entity));
    }

    @Override
    public FavoriteGuideResponseDTO update(Long touristId, Long guideId, FavoriteGuideUpdateRequestDTO dto) {
        FavoriteGuideId id = new FavoriteGuideId(touristId, guideId);
        FavoriteGuide entity = favoriteGuideRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FavoriteGuide not found with id: " + id));

        FavoriteGuideMapper.updateEntity(entity, dto);
        return FavoriteGuideMapper.toResponseDTO(favoriteGuideRepository.save(entity));
    }

    @Override
    public FavoriteGuideResponseDTO findById(Long touristId, Long guideId) {
        FavoriteGuideId id = new FavoriteGuideId(touristId, guideId);
        return favoriteGuideRepository.findById(id)
                .map(FavoriteGuideMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("FavoriteGuide not found with id: " + id));
    }

    @Override
    public List<FavoriteGuideResponseDTO> findAll() {
        return favoriteGuideRepository.findAll().stream()
                .map(FavoriteGuideMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long touristId, Long guideId) {
        FavoriteGuideId id = new FavoriteGuideId(touristId, guideId);
        if (!favoriteGuideRepository.existsById(id)) {
            throw new ResourceNotFoundException("FavoriteGuide not found with id: " + id);
        }
        favoriteGuideRepository.deleteById(id);
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