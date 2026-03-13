package org.generation.socialNetwork.tours.service;

import org.generation.socialNetwork.tours.dto.DestinationCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.DestinationResponseDTO;
import org.generation.socialNetwork.tours.dto.DestinationUpdateRequestDTO;
import org.generation.socialNetwork.tours.model.Destination;

public class DestinationMapper {

    private DestinationMapper() {
    }

    public static Destination toEntity(DestinationCreateRequestDTO dto) {
        Destination entity = new Destination();
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setCountry(dto.getCountry());
        entity.setDescription(dto.getDescription());
        entity.setImageUrl(dto.getImageUrl());
        entity.setIsFeatured(dto.getIsFeatured());
        return entity;
    }

    public static void updateEntity(Destination entity, DestinationUpdateRequestDTO dto) {
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setCountry(dto.getCountry());
        entity.setDescription(dto.getDescription());
        entity.setImageUrl(dto.getImageUrl());
        entity.setIsFeatured(dto.getIsFeatured());
    }

    public static DestinationResponseDTO toResponseDTO(Destination entity) {
        DestinationResponseDTO dto = new DestinationResponseDTO();
        dto.setDestinationId(entity.getDestinationId());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setCountry(entity.getCountry());
        dto.setDescription(entity.getDescription());
        dto.setImageUrl(entity.getImageUrl());
        dto.setIsFeatured(entity.getIsFeatured());
        return dto;
    }
}