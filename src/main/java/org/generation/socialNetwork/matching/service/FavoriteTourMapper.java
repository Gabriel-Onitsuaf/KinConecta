package org.generation.socialNetwork.matching.service;

import org.generation.socialNetwork.matching.dto.FavoriteTourCreateRequestDTO;
import org.generation.socialNetwork.matching.dto.FavoriteTourResponseDTO;
import org.generation.socialNetwork.matching.dto.FavoriteTourUpdateRequestDTO;
import org.generation.socialNetwork.matching.model.FavoriteTour;

public class FavoriteTourMapper {

    private FavoriteTourMapper() {
    }

    public static FavoriteTour toEntity(FavoriteTourCreateRequestDTO dto) {
        FavoriteTour entity = new FavoriteTour();
        entity.setTouristId(dto.getTouristId());
        entity.setTourId(dto.getTourId());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }

    public static void updateEntity(FavoriteTour entity, FavoriteTourUpdateRequestDTO dto) {
        entity.setCreatedAt(dto.getCreatedAt());
    }

    public static FavoriteTourResponseDTO toResponseDTO(FavoriteTour entity) {
        FavoriteTourResponseDTO dto = new FavoriteTourResponseDTO();
        dto.setTouristId(entity.getTouristId());
        dto.setTourId(entity.getTourId());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}