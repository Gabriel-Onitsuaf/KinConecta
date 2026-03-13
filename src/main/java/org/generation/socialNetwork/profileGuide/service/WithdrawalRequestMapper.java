package org.generation.socialNetwork.profileGuide.service;

import org.generation.socialNetwork.profileGuide.dto.WithdrawalRequestCreateRequestDTO;
import org.generation.socialNetwork.profileGuide.dto.WithdrawalRequestResponseDTO;
import org.generation.socialNetwork.profileGuide.dto.WithdrawalRequestUpdateRequestDTO;
import org.generation.socialNetwork.profileGuide.model.WithdrawalRequest;

public class WithdrawalRequestMapper {

    private WithdrawalRequestMapper() {
    }

    public static WithdrawalRequest toEntity(WithdrawalRequestCreateRequestDTO dto) {
        WithdrawalRequest entity = new WithdrawalRequest();
        entity.setGuideId(dto.getGuideId());
        entity.setRequestedAmount(dto.getRequestedAmount());
        entity.setStatus(dto.getStatus());
        entity.setBankReference(dto.getBankReference());
        entity.setNotes(dto.getNotes());
        entity.setRequestedAt(dto.getRequestedAt());
        entity.setProcessedAt(dto.getProcessedAt());
        entity.setProcessedByUserId(dto.getProcessedByUserId());
        return entity;
    }

    public static void updateEntity(WithdrawalRequest entity, WithdrawalRequestUpdateRequestDTO dto) {
        entity.setGuideId(dto.getGuideId());
        entity.setRequestedAmount(dto.getRequestedAmount());
        entity.setStatus(dto.getStatus());
        entity.setBankReference(dto.getBankReference());
        entity.setNotes(dto.getNotes());
        entity.setRequestedAt(dto.getRequestedAt());
        entity.setProcessedAt(dto.getProcessedAt());
        entity.setProcessedByUserId(dto.getProcessedByUserId());
    }

    public static WithdrawalRequestResponseDTO toResponseDTO(WithdrawalRequest entity) {
        WithdrawalRequestResponseDTO dto = new WithdrawalRequestResponseDTO();
        dto.setWithdrawalId(entity.getWithdrawalId());
        dto.setGuideId(entity.getGuideId());
        dto.setRequestedAmount(entity.getRequestedAmount());
        dto.setStatus(entity.getStatus());
        dto.setBankReference(entity.getBankReference());
        dto.setNotes(entity.getNotes());
        dto.setRequestedAt(entity.getRequestedAt());
        dto.setProcessedAt(entity.getProcessedAt());
        dto.setProcessedByUserId(entity.getProcessedByUserId());
        return dto;
    }
}