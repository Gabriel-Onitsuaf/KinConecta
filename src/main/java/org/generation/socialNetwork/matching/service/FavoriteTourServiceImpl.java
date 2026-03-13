package org.generation.socialNetwork.matching.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.matching.dto.FavoriteTourCreateRequestDTO;
import org.generation.socialNetwork.matching.dto.FavoriteTourResponseDTO;
import org.generation.socialNetwork.matching.dto.FavoriteTourUpdateRequestDTO;
import org.generation.socialNetwork.matching.model.FavoriteTour;
import org.generation.socialNetwork.matching.model.FavoriteTourId;
import org.generation.socialNetwork.matching.repository.FavoriteTourRepository;
import org.generation.socialNetwork.tours.repository.TourRepository;
import org.generation.socialNetwork.users.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavoriteTourServiceImpl implements FavoriteTourService {

    private final FavoriteTourRepository favoriteTourRepository;
    private final UserRepository userRepository;
    private final TourRepository tourRepository;

    @Override
    public FavoriteTourResponseDTO create(FavoriteTourCreateRequestDTO dto) {
        validateUserExists(dto.getTouristId(), "touristId");
        validateTourExists(dto.getTourId(), "tourId");
        FavoriteTour entity = FavoriteTourMapper.toEntity(dto);
        return FavoriteTourMapper.toResponseDTO(favoriteTourRepository.save(entity));
    }

    @Override
    public FavoriteTourResponseDTO update(Long touristId, Long tourId, FavoriteTourUpdateRequestDTO dto) {
        FavoriteTourId id = new FavoriteTourId(touristId, tourId);
        FavoriteTour entity = favoriteTourRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FavoriteTour not found with id: " + id));

        FavoriteTourMapper.updateEntity(entity, dto);
        return FavoriteTourMapper.toResponseDTO(favoriteTourRepository.save(entity));
    }

    @Override
    public FavoriteTourResponseDTO findById(Long touristId, Long tourId) {
        FavoriteTourId id = new FavoriteTourId(touristId, tourId);
        return favoriteTourRepository.findById(id)
                .map(FavoriteTourMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("FavoriteTour not found with id: " + id));
    }

    @Override
    public List<FavoriteTourResponseDTO> findAll() {
        return favoriteTourRepository.findAll().stream()
                .map(FavoriteTourMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long touristId, Long tourId) {
        FavoriteTourId id = new FavoriteTourId(touristId, tourId);
        if (!favoriteTourRepository.existsById(id)) {
            throw new ResourceNotFoundException("FavoriteTour not found with id: " + id);
        }
        favoriteTourRepository.deleteById(id);
    }

    private void validateUserExists(Long id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found for " + fieldName + ": " + id);
        }
    }
    private void validateTourExists(Long id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!tourRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tour not found for " + fieldName + ": " + id);
        }
    }
}