package org.generation.socialNetwork.profileGuide.service;

import org.generation.socialNetwork.profileGuide.dto.IncomeTransactionCreateRequestDTO;
import org.generation.socialNetwork.profileGuide.dto.IncomeTransactionResponseDTO;
import org.generation.socialNetwork.profileGuide.dto.IncomeTransactionUpdateRequestDTO;
import org.generation.socialNetwork.profileGuide.model.IncomeTransaction;

public class IncomeTransactionMapper {

    private IncomeTransactionMapper() {
    }

    public static IncomeTransaction toEntity(IncomeTransactionCreateRequestDTO dto) {
        IncomeTransaction entity = new IncomeTransaction();
        entity.setGuideId(dto.getGuideId());
        entity.setTripId(dto.getTripId());
        entity.setTourId(dto.getTourId());
        entity.setTxnType(dto.getTxnType());
        entity.setAmount(dto.getAmount());
        entity.setSign(dto.getSign());
        entity.setStatus(dto.getStatus());
        entity.setDescription(dto.getDescription());
        entity.setOccurredAt(dto.getOccurredAt());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }

    public static void updateEntity(IncomeTransaction entity, IncomeTransactionUpdateRequestDTO dto) {
        entity.setGuideId(dto.getGuideId());
        entity.setTripId(dto.getTripId());
        entity.setTourId(dto.getTourId());
        entity.setTxnType(dto.getTxnType());
        entity.setAmount(dto.getAmount());
        entity.setSign(dto.getSign());
        entity.setStatus(dto.getStatus());
        entity.setDescription(dto.getDescription());
        entity.setOccurredAt(dto.getOccurredAt());
        entity.setCreatedAt(dto.getCreatedAt());
    }

    public static IncomeTransactionResponseDTO toResponseDTO(IncomeTransaction entity) {
        IncomeTransactionResponseDTO dto = new IncomeTransactionResponseDTO();
        dto.setTransactionId(entity.getTransactionId());
        dto.setGuideId(entity.getGuideId());
        dto.setTripId(entity.getTripId());
        dto.setTourId(entity.getTourId());
        dto.setTxnType(entity.getTxnType());
        dto.setAmount(entity.getAmount());
        dto.setSign(entity.getSign());
        dto.setStatus(entity.getStatus());
        dto.setDescription(entity.getDescription());
        dto.setOccurredAt(entity.getOccurredAt());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}