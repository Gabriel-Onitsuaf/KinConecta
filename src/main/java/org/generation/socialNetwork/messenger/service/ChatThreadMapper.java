package org.generation.socialNetwork.messenger.service;

import org.generation.socialNetwork.messenger.dto.ChatThreadCreateRequestDTO;
import org.generation.socialNetwork.messenger.dto.ChatThreadResponseDTO;
import org.generation.socialNetwork.messenger.dto.ChatThreadUpdateRequestDTO;
import org.generation.socialNetwork.messenger.model.ChatThread;

public class ChatThreadMapper {

    private ChatThreadMapper() {
    }

    public static ChatThread toEntity(ChatThreadCreateRequestDTO dto) {
        ChatThread entity = new ChatThread();
        entity.setTripId(dto.getTripId());
        entity.setTouristId(dto.getTouristId());
        entity.setGuideId(dto.getGuideId());
        entity.setLastMessageAt(dto.getLastMessageAt());
        entity.setStatus(dto.getStatus());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }

    public static void updateEntity(ChatThread entity, ChatThreadUpdateRequestDTO dto) {
        entity.setTripId(dto.getTripId());
        entity.setTouristId(dto.getTouristId());
        entity.setGuideId(dto.getGuideId());
        entity.setLastMessageAt(dto.getLastMessageAt());
        entity.setStatus(dto.getStatus());
        entity.setCreatedAt(dto.getCreatedAt());
    }

    public static ChatThreadResponseDTO toResponseDTO(ChatThread entity) {
        ChatThreadResponseDTO dto = new ChatThreadResponseDTO();
        dto.setThreadId(entity.getThreadId());
        dto.setTripId(entity.getTripId());
        dto.setTouristId(entity.getTouristId());
        dto.setGuideId(entity.getGuideId());
        dto.setLastMessageAt(entity.getLastMessageAt());
        dto.setStatus(entity.getStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}