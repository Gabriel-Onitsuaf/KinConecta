package org.generation.socialNetwork.tours.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.tours.dto.TripBookingCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TripBookingResponseDTO;
import org.generation.socialNetwork.tours.dto.TripBookingUpdateRequestDTO;
import org.generation.socialNetwork.tours.model.TripBooking;
import org.generation.socialNetwork.tours.repository.TourRepository;
import org.generation.socialNetwork.tours.repository.TripBookingRepository;
import org.generation.socialNetwork.users.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripBookingServiceImpl implements TripBookingService {

    private final TripBookingRepository tripBookingRepository;
    private final TourRepository tourRepository;
    private final UserRepository userRepository;

    @Override
    public TripBookingResponseDTO create(TripBookingCreateRequestDTO dto) {
        validateTourExists(dto.getTourId(), "tourId");
        validateUserExists(dto.getTouristId(), "touristId");
        validateUserExists(dto.getGuideId(), "guideId");
        TripBooking entity = TripBookingMapper.toEntity(dto);
        return TripBookingMapper.toResponseDTO(tripBookingRepository.save(entity));
    }

    @Override
    public TripBookingResponseDTO update(Long id, TripBookingUpdateRequestDTO dto) {
        TripBooking entity = tripBookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TripBooking not found with id: " + id));
        validateTourExists(dto.getTourId(), "tourId");
        validateUserExists(dto.getTouristId(), "touristId");
        validateUserExists(dto.getGuideId(), "guideId");
        TripBookingMapper.updateEntity(entity, dto);
        return TripBookingMapper.toResponseDTO(tripBookingRepository.save(entity));
    }

    @Override
    public TripBookingResponseDTO findById(Long id) {
        return tripBookingRepository.findById(id)
                .map(TripBookingMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("TripBooking not found with id: " + id));
    }

    @Override
    public List<TripBookingResponseDTO> findAll() {
        return tripBookingRepository.findAll().stream()
                .map(TripBookingMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!tripBookingRepository.existsById(id)) {
            throw new ResourceNotFoundException("TripBooking not found with id: " + id);
        }
        tripBookingRepository.deleteById(id);
    }

    private void validateTourExists(Long id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!tourRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tour not found for " + fieldName + ": " + id);
        }
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