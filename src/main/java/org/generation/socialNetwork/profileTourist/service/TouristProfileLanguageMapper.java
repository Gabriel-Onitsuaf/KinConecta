package org.generation.socialNetwork.profileTourist.service;

import org.generation.socialNetwork.profileTourist.dto.TouristProfileLanguageCreateRequestDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileLanguageResponseDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileLanguageUpdateRequestDTO;
import org.generation.socialNetwork.profileTourist.model.TouristProfileLanguage;

public class TouristProfileLanguageMapper {

    private TouristProfileLanguageMapper() {
    }

    public static TouristProfileLanguage toEntity(TouristProfileLanguageCreateRequestDTO dto) {
        TouristProfileLanguage entity = new TouristProfileLanguage();
        entity.setUserId(dto.getUserId());
        entity.setLanguageCode(dto.getLanguageCode());
        return entity;
    }

    public static void updateEntity(TouristProfileLanguage entity, TouristProfileLanguageUpdateRequestDTO dto) {

    }

    public static TouristProfileLanguageResponseDTO toResponseDTO(TouristProfileLanguage entity) {
        TouristProfileLanguageResponseDTO dto = new TouristProfileLanguageResponseDTO();
        dto.setUserId(entity.getUserId());
        dto.setLanguageCode(entity.getLanguageCode());
        return dto;
    }
}