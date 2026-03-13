package org.generation.socialNetwork.tours.service;

import org.generation.socialNetwork.tours.dto.TourCategoryCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TourCategoryResponseDTO;
import org.generation.socialNetwork.tours.dto.TourCategoryUpdateRequestDTO;
import org.generation.socialNetwork.tours.model.TourCategory;

public class TourCategoryMapper {

    private TourCategoryMapper() {
    }

    public static TourCategory toEntity(TourCategoryCreateRequestDTO dto) {
        TourCategory entity = new TourCategory();
        entity.setName(dto.getName());
        return entity;
    }

    public static void updateEntity(TourCategory entity, TourCategoryUpdateRequestDTO dto) {
        entity.setName(dto.getName());
    }

    public static TourCategoryResponseDTO toResponseDTO(TourCategory entity) {
        TourCategoryResponseDTO dto = new TourCategoryResponseDTO();
        dto.setCategoryId(entity.getCategoryId());
        dto.setName(entity.getName());
        return dto;
    }
}