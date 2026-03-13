package org.generation.socialNetwork.help.service;

import org.generation.socialNetwork.help.dto.SupportTicketAttachmentCreateRequestDTO;
import org.generation.socialNetwork.help.dto.SupportTicketAttachmentResponseDTO;
import org.generation.socialNetwork.help.dto.SupportTicketAttachmentUpdateRequestDTO;
import org.generation.socialNetwork.help.model.SupportTicketAttachment;

public class SupportTicketAttachmentMapper {

    private SupportTicketAttachmentMapper() {
    }

    public static SupportTicketAttachment toEntity(SupportTicketAttachmentCreateRequestDTO dto) {
        SupportTicketAttachment entity = new SupportTicketAttachment();
        entity.setTicketId(dto.getTicketId());
        entity.setFileUrl(dto.getFileUrl());
        entity.setFileName(dto.getFileName());
        entity.setMimeType(dto.getMimeType());
        entity.setFileSizeBytes(dto.getFileSizeBytes());
        entity.setUploadedAt(dto.getUploadedAt());
        return entity;
    }

    public static void updateEntity(SupportTicketAttachment entity, SupportTicketAttachmentUpdateRequestDTO dto) {
        entity.setTicketId(dto.getTicketId());
        entity.setFileUrl(dto.getFileUrl());
        entity.setFileName(dto.getFileName());
        entity.setMimeType(dto.getMimeType());
        entity.setFileSizeBytes(dto.getFileSizeBytes());
        entity.setUploadedAt(dto.getUploadedAt());
    }

    public static SupportTicketAttachmentResponseDTO toResponseDTO(SupportTicketAttachment entity) {
        SupportTicketAttachmentResponseDTO dto = new SupportTicketAttachmentResponseDTO();
        dto.setAttachmentId(entity.getAttachmentId());
        dto.setTicketId(entity.getTicketId());
        dto.setFileUrl(entity.getFileUrl());
        dto.setFileName(entity.getFileName());
        dto.setMimeType(entity.getMimeType());
        dto.setFileSizeBytes(entity.getFileSizeBytes());
        dto.setUploadedAt(entity.getUploadedAt());
        return dto;
    }
}