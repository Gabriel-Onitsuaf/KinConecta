package org.generation.socialNetwork.tours.service;

import org.generation.socialNetwork.tours.dto.TripStatusHistoryCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TripStatusHistoryResponseDTO;
import org.generation.socialNetwork.tours.dto.TripStatusHistoryUpdateRequestDTO;
import org.generation.socialNetwork.tours.model.TripStatusHistory;

public class TripStatusHistoryMapper {

    private TripStatusHistoryMapper() {
    }

    public static TripStatusHistory toEntity(TripStatusHistoryCreateRequestDTO dto) {
        TripStatusHistory entity = new TripStatusHistory();
        entity.setTripId(dto.getTripId());
        entity.setOldStatus(dto.getOldStatus());
        entity.setNewStatus(dto.getNewStatus());
        entity.setReason(dto.getReason());
        entity.setChangedByUserId(dto.getChangedByUserId());
        entity.setChangedAt(dto.getChangedAt());
        return entity;
    }

    public static void updateEntity(TripStatusHistory entity, TripStatusHistoryUpdateRequestDTO dto) {
        entity.setTripId(dto.getTripId());
        entity.setOldStatus(dto.getOldStatus());
        entity.setNewStatus(dto.getNewStatus());
        entity.setReason(dto.getReason());
        entity.setChangedByUserId(dto.getChangedByUserId());
        entity.setChangedAt(dto.getChangedAt());
    }

    public static TripStatusHistoryResponseDTO toResponseDTO(TripStatusHistory entity) {
        TripStatusHistoryResponseDTO dto = new TripStatusHistoryResponseDTO();
        dto.setHistoryId(entity.getHistoryId());
        dto.setTripId(entity.getTripId());
        dto.setOldStatus(entity.getOldStatus());
        dto.setNewStatus(entity.getNewStatus());
        dto.setReason(entity.getReason());
        dto.setChangedByUserId(entity.getChangedByUserId());
        dto.setChangedAt(entity.getChangedAt());
        return dto;
    }
}