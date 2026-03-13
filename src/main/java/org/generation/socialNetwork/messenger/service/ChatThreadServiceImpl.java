package org.generation.socialNetwork.messenger.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.messenger.dto.ChatThreadCreateRequestDTO;
import org.generation.socialNetwork.messenger.dto.ChatThreadResponseDTO;
import org.generation.socialNetwork.messenger.dto.ChatThreadUpdateRequestDTO;
import org.generation.socialNetwork.messenger.model.ChatThread;
import org.generation.socialNetwork.messenger.repository.ChatThreadRepository;
import org.generation.socialNetwork.tours.repository.TripBookingRepository;
import org.generation.socialNetwork.users.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatThreadServiceImpl implements ChatThreadService {

    private final ChatThreadRepository chatThreadRepository;
    private final TripBookingRepository tripBookingRepository;
    private final UserRepository userRepository;

    @Override
    public ChatThreadResponseDTO create(ChatThreadCreateRequestDTO dto) {
        validateTripBookingExists(dto.getTripId(), "tripId");
        validateUserExists(dto.getTouristId(), "touristId");
        validateUserExists(dto.getGuideId(), "guideId");
        ChatThread entity = ChatThreadMapper.toEntity(dto);
        return ChatThreadMapper.toResponseDTO(chatThreadRepository.save(entity));
    }

    @Override
    public ChatThreadResponseDTO update(Long id, ChatThreadUpdateRequestDTO dto) {
        ChatThread entity = chatThreadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ChatThread not found with id: " + id));
        validateTripBookingExists(dto.getTripId(), "tripId");
        validateUserExists(dto.getTouristId(), "touristId");
        validateUserExists(dto.getGuideId(), "guideId");
        ChatThreadMapper.updateEntity(entity, dto);
        return ChatThreadMapper.toResponseDTO(chatThreadRepository.save(entity));
    }

    @Override
    public ChatThreadResponseDTO findById(Long id) {
        return chatThreadRepository.findById(id)
                .map(ChatThreadMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("ChatThread not found with id: " + id));
    }

    @Override
    public List<ChatThreadResponseDTO> findAll() {
        return chatThreadRepository.findAll().stream()
                .map(ChatThreadMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!chatThreadRepository.existsById(id)) {
            throw new ResourceNotFoundException("ChatThread not found with id: " + id);
        }
        chatThreadRepository.deleteById(id);
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