package org.generation.socialNetwork.notifications.service;

import org.generation.socialNetwork.notifications.dto.NotificationCreateRequestDTO;
import org.generation.socialNetwork.notifications.dto.NotificationResponseDTO;
import org.generation.socialNetwork.notifications.dto.NotificationUpdateRequestDTO;
import org.generation.socialNetwork.notifications.model.Notification;

public class NotificationMapper {

    private NotificationMapper() {
    }

    public static Notification toEntity(NotificationCreateRequestDTO dto) {
        Notification entity = new Notification();
        entity.setUserId(dto.getUserId());
        entity.setType(dto.getType());
        entity.setTitle(dto.getTitle());
        entity.setBody(dto.getBody());
        entity.setRelatedEntityType(dto.getRelatedEntityType());
        entity.setRelatedEntityId(dto.getRelatedEntityId());
        entity.setIsRead(dto.getIsRead());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setReadAt(dto.getReadAt());
        return entity;
    }

    public static void updateEntity(Notification entity, NotificationUpdateRequestDTO dto) {
        entity.setUserId(dto.getUserId());
        entity.setType(dto.getType());
        entity.setTitle(dto.getTitle());
        entity.setBody(dto.getBody());
        entity.setRelatedEntityType(dto.getRelatedEntityType());
        entity.setRelatedEntityId(dto.getRelatedEntityId());
        entity.setIsRead(dto.getIsRead());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setReadAt(dto.getReadAt());
    }

    public static NotificationResponseDTO toResponseDTO(Notification entity) {
        NotificationResponseDTO dto = new NotificationResponseDTO();
        dto.setNotificationId(entity.getNotificationId());
        dto.setUserId(entity.getUserId());
        dto.setType(entity.getType());
        dto.setTitle(entity.getTitle());
        dto.setBody(entity.getBody());
        dto.setRelatedEntityType(entity.getRelatedEntityType());
        dto.setRelatedEntityId(entity.getRelatedEntityId());
        dto.setIsRead(entity.getIsRead());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setReadAt(entity.getReadAt());
        return dto;
    }
}