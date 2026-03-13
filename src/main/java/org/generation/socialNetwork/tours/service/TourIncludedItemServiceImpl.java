package org.generation.socialNetwork.tours.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.tours.dto.TourIncludedItemCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TourIncludedItemResponseDTO;
import org.generation.socialNetwork.tours.dto.TourIncludedItemUpdateRequestDTO;
import org.generation.socialNetwork.tours.model.TourIncludedItem;
import org.generation.socialNetwork.tours.repository.TourIncludedItemRepository;
import org.generation.socialNetwork.tours.repository.TourRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TourIncludedItemServiceImpl implements TourIncludedItemService {

    private final TourIncludedItemRepository tourIncludedItemRepository;
    private final TourRepository tourRepository;

    @Override
    public TourIncludedItemResponseDTO create(TourIncludedItemCreateRequestDTO dto) {
        validateTourExists(dto.getTourId(), "tourId");
        TourIncludedItem entity = TourIncludedItemMapper.toEntity(dto);
        return TourIncludedItemMapper.toResponseDTO(tourIncludedItemRepository.save(entity));
    }

    @Override
    public TourIncludedItemResponseDTO update(Long id, TourIncludedItemUpdateRequestDTO dto) {
        TourIncludedItem entity = tourIncludedItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TourIncludedItem not found with id: " + id));
        validateTourExists(dto.getTourId(), "tourId");
        TourIncludedItemMapper.updateEntity(entity, dto);
        return TourIncludedItemMapper.toResponseDTO(tourIncludedItemRepository.save(entity));
    }

    @Override
    public TourIncludedItemResponseDTO findById(Long id) {
        return tourIncludedItemRepository.findById(id)
                .map(TourIncludedItemMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("TourIncludedItem not found with id: " + id));
    }

    @Override
    public List<TourIncludedItemResponseDTO> findAll() {
        return tourIncludedItemRepository.findAll().stream()
                .map(TourIncludedItemMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!tourIncludedItemRepository.existsById(id)) {
            throw new ResourceNotFoundException("TourIncludedItem not found with id: " + id);
        }
        tourIncludedItemRepository.deleteById(id);
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