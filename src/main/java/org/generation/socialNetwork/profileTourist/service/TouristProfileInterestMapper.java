package org.generation.socialNetwork.profileTourist.service;

import org.generation.socialNetwork.profileTourist.dto.TouristProfileInterestCreateRequestDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileInterestResponseDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileInterestUpdateRequestDTO;
import org.generation.socialNetwork.profileTourist.model.TouristProfileInterest;

public class TouristProfileInterestMapper {

    private TouristProfileInterestMapper() {
    }

    public static TouristProfileInterest toEntity(TouristProfileInterestCreateRequestDTO dto) {
        TouristProfileInterest entity = new TouristProfileInterest();
        entity.setUserId(dto.getUserId());
        entity.setInterestId(dto.getInterestId());
        return entity;
    }

    public static void updateEntity(TouristProfileInterest entity, TouristProfileInterestUpdateRequestDTO dto) {

    }

    public static TouristProfileInterestResponseDTO toResponseDTO(TouristProfileInterest entity) {
        TouristProfileInterestResponseDTO dto = new TouristProfileInterestResponseDTO();
        dto.setUserId(entity.getUserId());
        dto.setInterestId(entity.getInterestId());
        return dto;
    }
}