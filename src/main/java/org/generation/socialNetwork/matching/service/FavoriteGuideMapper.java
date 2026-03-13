package org.generation.socialNetwork.matching.service;

import org.generation.socialNetwork.matching.dto.FavoriteGuideCreateRequestDTO;
import org.generation.socialNetwork.matching.dto.FavoriteGuideResponseDTO;
import org.generation.socialNetwork.matching.dto.FavoriteGuideUpdateRequestDTO;
import org.generation.socialNetwork.matching.model.FavoriteGuide;

public class FavoriteGuideMapper {

    private FavoriteGuideMapper() {
    }

    public static FavoriteGuide toEntity(FavoriteGuideCreateRequestDTO dto) {
        FavoriteGuide entity = new FavoriteGuide();
        entity.setTouristId(dto.getTouristId());
        entity.setGuideId(dto.getGuideId());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }

    public static void updateEntity(FavoriteGuide entity, FavoriteGuideUpdateRequestDTO dto) {
        entity.setCreatedAt(dto.getCreatedAt());
    }

    public static FavoriteGuideResponseDTO toResponseDTO(FavoriteGuide entity) {
        FavoriteGuideResponseDTO dto = new FavoriteGuideResponseDTO();
        dto.setTouristId(entity.getTouristId());
        dto.setGuideId(entity.getGuideId());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}