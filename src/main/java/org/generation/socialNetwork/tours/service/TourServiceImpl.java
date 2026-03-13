package org.generation.socialNetwork.tours.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.tours.dto.TourCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TourResponseDTO;
import org.generation.socialNetwork.tours.dto.TourUpdateRequestDTO;
import org.generation.socialNetwork.tours.model.Tour;
import org.generation.socialNetwork.tours.model.TourStatus;
import org.generation.socialNetwork.tours.repository.TourCategoryRepository;
import org.generation.socialNetwork.tours.repository.TourRepository;
import org.generation.socialNetwork.users.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;
    private final UserRepository userRepository;
    private final TourCategoryRepository tourCategoryRepository;

    @Override
    public TourResponseDTO create(TourCreateRequestDTO dto) {
        validateUserExists(dto.getGuideId(), "guideId");
        validateTourCategoryExists(dto.getCategoryId(), "categoryId");
        Tour entity = TourMapper.toEntity(dto);
        applyCreateDefaults(entity);
        return TourMapper.toResponseDTO(tourRepository.save(entity));
    }

    @Override
    public TourResponseDTO update(Long id, TourUpdateRequestDTO dto) {
        Tour entity = tourRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tour not found with id: " + id));
        validateUserExists(dto.getGuideId(), "guideId");
        validateTourCategoryExists(dto.getCategoryId(), "categoryId");
        TourMapper.updateEntity(entity, dto);
        applyUpdateDefaults(entity);
        return TourMapper.toResponseDTO(tourRepository.save(entity));
    }

    @Override
    public TourResponseDTO findById(Long id) {
        return tourRepository.findById(id)
                .map(TourMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Tour not found with id: " + id));
    }

    @Override
    public List<TourResponseDTO> findAll() {
        return tourRepository.findAll().stream()
                .map(TourMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!tourRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tour not found with id: " + id);
        }
        tourRepository.deleteById(id);
    }

    private void validateUserExists(Long id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found for " + fieldName + ": " + id);
        }
    }
    private void validateTourCategoryExists(Integer id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!tourCategoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("TourCategory not found for " + fieldName + ": " + id);
        }
    }

    private void applyCreateDefaults(Tour entity) {
        LocalDateTime now = LocalDateTime.now();
        if (entity.getCurrency() == null || entity.getCurrency().isBlank()) {
            entity.setCurrency("MXN");
        }
        if (entity.getStatus() == null) {
            entity.setStatus(TourStatus.DRAFT);
        }
        if (entity.getRatingAvg() == null) {
            entity.setRatingAvg(BigDecimal.ZERO);
        }
        if (entity.getBookingsCount() == null) {
            entity.setBookingsCount(0);
        }
        if (entity.getCreatedAt() == null) {
            entity.setCreatedAt(now);
        }
        if (entity.getUpdatedAt() == null) {
            entity.setUpdatedAt(now);
        }
    }

    private void applyUpdateDefaults(Tour entity) {
        if (entity.getCurrency() == null || entity.getCurrency().isBlank()) {
            entity.setCurrency("MXN");
        }
        if (entity.getStatus() == null) {
            entity.setStatus(TourStatus.DRAFT);
        }
        if (entity.getRatingAvg() == null) {
            entity.setRatingAvg(BigDecimal.ZERO);
        }
        if (entity.getBookingsCount() == null) {
            entity.setBookingsCount(0);
        }
        if (entity.getCreatedAt() == null) {
            entity.setCreatedAt(LocalDateTime.now());
        }
        entity.setUpdatedAt(LocalDateTime.now());
    }
}
