package org.generation.socialNetwork.help.service;

import org.generation.socialNetwork.help.dto.SupportTicketCreateRequestDTO;
import org.generation.socialNetwork.help.dto.SupportTicketResponseDTO;
import org.generation.socialNetwork.help.dto.SupportTicketUpdateRequestDTO;
import org.generation.socialNetwork.help.model.SupportTicket;

public class SupportTicketMapper {

    private SupportTicketMapper() {
    }

    public static SupportTicket toEntity(SupportTicketCreateRequestDTO dto) {
        SupportTicket entity = new SupportTicket();
        entity.setUserId(dto.getUserId());
        entity.setRoleContext(dto.getRoleContext());
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setSubject(dto.getSubject());
        entity.setCategory(dto.getCategory());
        entity.setMessage(dto.getMessage());
        entity.setStatus(dto.getStatus());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }

    public static void updateEntity(SupportTicket entity, SupportTicketUpdateRequestDTO dto) {
        entity.setUserId(dto.getUserId());
        entity.setRoleContext(dto.getRoleContext());
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setSubject(dto.getSubject());
        entity.setCategory(dto.getCategory());
        entity.setMessage(dto.getMessage());
        entity.setStatus(dto.getStatus());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
    }

    public static SupportTicketResponseDTO toResponseDTO(SupportTicket entity) {
        SupportTicketResponseDTO dto = new SupportTicketResponseDTO();
        dto.setTicketId(entity.getTicketId());
        dto.setUserId(entity.getUserId());
        dto.setRoleContext(entity.getRoleContext());
        dto.setFullName(entity.getFullName());
        dto.setEmail(entity.getEmail());
        dto.setSubject(entity.getSubject());
        dto.setCategory(entity.getCategory());
        dto.setMessage(entity.getMessage());
        dto.setStatus(entity.getStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}