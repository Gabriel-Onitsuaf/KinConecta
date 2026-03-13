package org.generation.socialNetwork.messenger.service;

import org.generation.socialNetwork.messenger.dto.ChatMessageCreateRequestDTO;
import org.generation.socialNetwork.messenger.dto.ChatMessageResponseDTO;
import org.generation.socialNetwork.messenger.dto.ChatMessageUpdateRequestDTO;
import org.generation.socialNetwork.messenger.model.ChatMessage;

public class ChatMessageMapper {

    private ChatMessageMapper() {
    }

    public static ChatMessage toEntity(ChatMessageCreateRequestDTO dto) {
        ChatMessage entity = new ChatMessage();
        entity.setThreadId(dto.getThreadId());
        entity.setSenderUserId(dto.getSenderUserId());
        entity.setBody(dto.getBody());
        entity.setMessageType(dto.getMessageType());
        entity.setSentAt(dto.getSentAt());
        entity.setReadAt(dto.getReadAt());
        return entity;
    }

    public static void updateEntity(ChatMessage entity, ChatMessageUpdateRequestDTO dto) {
        entity.setThreadId(dto.getThreadId());
        entity.setSenderUserId(dto.getSenderUserId());
        entity.setBody(dto.getBody());
        entity.setMessageType(dto.getMessageType());
        entity.setSentAt(dto.getSentAt());
        entity.setReadAt(dto.getReadAt());
    }

    public static ChatMessageResponseDTO toResponseDTO(ChatMessage entity) {
        ChatMessageResponseDTO dto = new ChatMessageResponseDTO();
        dto.setMessageId(entity.getMessageId());
        dto.setThreadId(entity.getThreadId());
        dto.setSenderUserId(entity.getSenderUserId());
        dto.setBody(entity.getBody());
        dto.setMessageType(entity.getMessageType());
        dto.setSentAt(entity.getSentAt());
        dto.setReadAt(entity.getReadAt());
        return dto;
    }
}