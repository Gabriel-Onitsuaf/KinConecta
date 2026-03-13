package org.generation.socialNetwork.tours.service;

import org.generation.socialNetwork.tours.dto.TourDestinationCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TourDestinationResponseDTO;
import org.generation.socialNetwork.tours.dto.TourDestinationUpdateRequestDTO;
import org.generation.socialNetwork.tours.model.TourDestination;

public class TourDestinationMapper {

    private TourDestinationMapper() {
    }

    public static TourDestination toEntity(TourDestinationCreateRequestDTO dto) {
        TourDestination entity = new TourDestination();
        entity.setTourId(dto.getTourId());
        entity.setDestinationId(dto.getDestinationId());
        return entity;
    }

    public static void updateEntity(TourDestination entity, TourDestinationUpdateRequestDTO dto) {

    }

    public static TourDestinationResponseDTO toResponseDTO(TourDestination entity) {
        TourDestinationResponseDTO dto = new TourDestinationResponseDTO();
        dto.setTourId(entity.getTourId());
        dto.setDestinationId(entity.getDestinationId());
        return dto;
    }
}