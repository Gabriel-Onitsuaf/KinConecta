package org.generation.socialNetwork.tours.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.tours.dto.TripStatusHistoryCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TripStatusHistoryResponseDTO;
import org.generation.socialNetwork.tours.dto.TripStatusHistoryUpdateRequestDTO;
import org.generation.socialNetwork.tours.model.TripStatusHistory;
import org.generation.socialNetwork.tours.repository.TripBookingRepository;
import org.generation.socialNetwork.tours.repository.TripStatusHistoryRepository;
import org.generation.socialNetwork.users.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripStatusHistoryServiceImpl implements TripStatusHistoryService {

    private final TripStatusHistoryRepository tripStatusHistoryRepository;
    private final TripBookingRepository tripBookingRepository;
    private final UserRepository userRepository;

    @Override
    public TripStatusHistoryResponseDTO create(TripStatusHistoryCreateRequestDTO dto) {
        validateTripBookingExists(dto.getTripId(), "tripId");
        validateUserExists(dto.getChangedByUserId(), "changedByUserId");
        TripStatusHistory entity = TripStatusHistoryMapper.toEntity(dto);
        return TripStatusHistoryMapper.toResponseDTO(tripStatusHistoryRepository.save(entity));
    }

    @Override
    public TripStatusHistoryResponseDTO update(Long id, TripStatusHistoryUpdateRequestDTO dto) {
        TripStatusHistory entity = tripStatusHistoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TripStatusHistory not found with id: " + id));
        validateTripBookingExists(dto.getTripId(), "tripId");
        validateUserExists(dto.getChangedByUserId(), "changedByUserId");
        TripStatusHistoryMapper.updateEntity(entity, dto);
        return TripStatusHistoryMapper.toResponseDTO(tripStatusHistoryRepository.save(entity));
    }

    @Override
    public TripStatusHistoryResponseDTO findById(Long id) {
        return tripStatusHistoryRepository.findById(id)
                .map(TripStatusHistoryMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("TripStatusHistory not found with id: " + id));
    }

    @Override
    public List<TripStatusHistoryResponseDTO> findAll() {
        return tripStatusHistoryRepository.findAll().stream()
                .map(TripStatusHistoryMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!tripStatusHistoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("TripStatusHistory not found with id: " + id);
        }
        tripStatusHistoryRepository.deleteById(id);
    }

    private void validateTripBookingExists(Long id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!tripBookingRepository.existsById(id)) {
            throw new ResourceNotFoundException("TripBooking not found for " + fieldName + ": " + id);
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