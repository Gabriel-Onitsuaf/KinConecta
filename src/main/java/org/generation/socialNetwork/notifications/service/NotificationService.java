package org.generation.socialNetwork.notifications.service;

import org.generation.socialNetwork.notifications.dto.NotificationCreateRequestDTO;
import org.generation.socialNetwork.notifications.dto.NotificationResponseDTO;
import org.generation.socialNetwork.notifications.dto.NotificationUpdateRequestDTO;

import java.util.List;

public interface NotificationService {

    NotificationResponseDTO create(NotificationCreateRequestDTO dto);

    NotificationResponseDTO update(Long id, NotificationUpdateRequestDTO dto);

    NotificationResponseDTO findById(Long id);

    List<NotificationResponseDTO> findAll();

    void delete(Long id);
}