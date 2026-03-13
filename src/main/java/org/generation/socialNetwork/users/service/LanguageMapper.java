package org.generation.socialNetwork.users.service;

import org.generation.socialNetwork.users.dto.LanguageCreateRequestDTO;
import org.generation.socialNetwork.users.dto.LanguageResponseDTO;
import org.generation.socialNetwork.users.dto.LanguageUpdateRequestDTO;
import org.generation.socialNetwork.users.model.Language;

public class LanguageMapper {

    private LanguageMapper() {
    }

    public static Language toEntity(LanguageCreateRequestDTO dto) {
        Language entity = new Language();
        entity.setLanguageCode(dto.getLanguageCode());
        entity.setName(dto.getName());
        return entity;
    }

    public static void updateEntity(Language entity, LanguageUpdateRequestDTO dto) {
        entity.setName(dto.getName());
    }

    public static LanguageResponseDTO toResponseDTO(Language entity) {
        LanguageResponseDTO dto = new LanguageResponseDTO();
        dto.setLanguageCode(entity.getLanguageCode());
        dto.setName(entity.getName());
        return dto;
    }
}