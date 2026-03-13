package org.generation.socialNetwork.tours.service;

import org.generation.socialNetwork.tours.dto.TourIncludedItemCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TourIncludedItemResponseDTO;
import org.generation.socialNetwork.tours.dto.TourIncludedItemUpdateRequestDTO;
import org.generation.socialNetwork.tours.model.TourIncludedItem;

public class TourIncludedItemMapper {

    private TourIncludedItemMapper() {
    }

    public static TourIncludedItem toEntity(TourIncludedItemCreateRequestDTO dto) {
        TourIncludedItem entity = new TourIncludedItem();
        entity.setTourId(dto.getTourId());
        entity.setItemText(dto.getItemText());
        entity.setSortOrder(dto.getSortOrder());
        return entity;
    }

    public static void updateEntity(TourIncludedItem entity, TourIncludedItemUpdateRequestDTO dto) {
        entity.setTourId(dto.getTourId());
        entity.setItemText(dto.getItemText());
        entity.setSortOrder(dto.getSortOrder());
    }

    public static TourIncludedItemResponseDTO toResponseDTO(TourIncludedItem entity) {
        TourIncludedItemResponseDTO dto = new TourIncludedItemResponseDTO();
        dto.setItemId(entity.getItemId());
        dto.setTourId(entity.getTourId());
        dto.setItemText(entity.getItemText());
        dto.setSortOrder(entity.getSortOrder());
        return dto;
    }
}