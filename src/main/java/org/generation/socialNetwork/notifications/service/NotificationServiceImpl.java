package org.generation.socialNetwork.notifications.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.notifications.dto.NotificationCreateRequestDTO;
import org.generation.socialNetwork.notifications.dto.NotificationResponseDTO;
import org.generation.socialNetwork.notifications.dto.NotificationUpdateRequestDTO;
import org.generation.socialNetwork.notifications.model.Notification;
import org.generation.socialNetwork.notifications.repository.NotificationRepository;
import org.generation.socialNetwork.users.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    @Override
    public NotificationResponseDTO create(NotificationCreateRequestDTO dto) {
        validateUserExists(dto.getUserId(), "userId");
        Notification entity = NotificationMapper.toEntity(dto);
        return NotificationMapper.toResponseDTO(notificationRepository.save(entity));
    }

    @Override
    public NotificationResponseDTO update(Long id, NotificationUpdateRequestDTO dto) {
        Notification entity = notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found with id: " + id));
        validateUserExists(dto.getUserId(), "userId");
        NotificationMapper.updateEntity(entity, dto);
        return NotificationMapper.toResponseDTO(notificationRepository.save(entity));
    }

    @Override
    public NotificationResponseDTO findById(Long id) {
        return notificationRepository.findById(id)
                .map(NotificationMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found with id: " + id));
    }

    @Override
    public List<NotificationResponseDTO> findAll() {
        return notificationRepository.findAll().stream()
                .map(NotificationMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!notificationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Notification not found with id: " + id);
        }
        notificationRepository.deleteById(id);
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