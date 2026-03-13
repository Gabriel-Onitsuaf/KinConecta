package org.generation.socialNetwork.tours.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.tours.dto.TourDestinationCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TourDestinationResponseDTO;
import org.generation.socialNetwork.tours.dto.TourDestinationUpdateRequestDTO;
import org.generation.socialNetwork.tours.model.TourDestination;
import org.generation.socialNetwork.tours.model.TourDestinationId;
import org.generation.socialNetwork.tours.repository.DestinationRepository;
import org.generation.socialNetwork.tours.repository.TourDestinationRepository;
import org.generation.socialNetwork.tours.repository.TourRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TourDestinationServiceImpl implements TourDestinationService {

    private final TourDestinationRepository tourDestinationRepository;
    private final TourRepository tourRepository;
    private final DestinationRepository destinationRepository;

    @Override
    public TourDestinationResponseDTO create(TourDestinationCreateRequestDTO dto) {
        validateTourExists(dto.getTourId(), "tourId");
        validateDestinationExists(dto.getDestinationId(), "destinationId");
        TourDestination entity = TourDestinationMapper.toEntity(dto);
        return TourDestinationMapper.toResponseDTO(tourDestinationRepository.save(entity));
    }

    @Override
    public TourDestinationResponseDTO update(Long tourId, Long destinationId, TourDestinationUpdateRequestDTO dto) {
        TourDestinationId id = new TourDestinationId(tourId, destinationId);
        TourDestination entity = tourDestinationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TourDestination not found with id: " + id));

        TourDestinationMapper.updateEntity(entity, dto);
        return TourDestinationMapper.toResponseDTO(tourDestinationRepository.save(entity));
    }

    @Override
    public TourDestinationResponseDTO findById(Long tourId, Long destinationId) {
        TourDestinationId id = new TourDestinationId(tourId, destinationId);
        return tourDestinationRepository.findById(id)
                .map(TourDestinationMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("TourDestination not found with id: " + id));
    }

    @Override
    public List<TourDestinationResponseDTO> findAll() {
        return tourDestinationRepository.findAll().stream()
                .map(TourDestinationMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long tourId, Long destinationId) {
        TourDestinationId id = new TourDestinationId(tourId, destinationId);
        if (!tourDestinationRepository.existsById(id)) {
            throw new ResourceNotFoundException("TourDestination not found with id: " + id);
        }
        tourDestinationRepository.deleteById(id);
    }

    private void validateTourExists(Long id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!tourRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tour not found for " + fieldName + ": " + id);
        }
    }
    private void validateDestinationExists(Long id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!destinationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Destination not found for " + fieldName + ": " + id);
        }
    }
}