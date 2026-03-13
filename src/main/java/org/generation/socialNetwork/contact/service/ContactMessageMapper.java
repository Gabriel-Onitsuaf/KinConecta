package org.generation.socialNetwork.contact.service;

import org.generation.socialNetwork.contact.dto.ContactMessageCreateRequestDTO;
import org.generation.socialNetwork.contact.dto.ContactMessageResponseDTO;
import org.generation.socialNetwork.contact.dto.ContactMessageUpdateRequestDTO;
import org.generation.socialNetwork.contact.model.ContactMessage;

public class ContactMessageMapper {

    private ContactMessageMapper() {
    }

    public static ContactMessage toEntity(ContactMessageCreateRequestDTO dto) {
        ContactMessage entity = new ContactMessage();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setSubject(dto.getSubject());
        entity.setMessage(dto.getMessage());
        entity.setSourcePage(dto.getSourcePage());
        entity.setStatus(dto.getStatus());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }

    public static void updateEntity(ContactMessage entity, ContactMessageUpdateRequestDTO dto) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setSubject(dto.getSubject());
        entity.setMessage(dto.getMessage());
        entity.setSourcePage(dto.getSourcePage());
        entity.setStatus(dto.getStatus());
        entity.setCreatedAt(dto.getCreatedAt());
    }

    public static ContactMessageResponseDTO toResponseDTO(ContactMessage entity) {
        ContactMessageResponseDTO dto = new ContactMessageResponseDTO();
        dto.setContactMessageId(entity.getContactMessageId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setSubject(entity.getSubject());
        dto.setMessage(entity.getMessage());
        dto.setSourcePage(entity.getSourcePage());
        dto.setStatus(entity.getStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}