package org.generation.socialNetwork.tours.service;

import org.generation.socialNetwork.tours.dto.TripBookingCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TripBookingResponseDTO;
import org.generation.socialNetwork.tours.dto.TripBookingUpdateRequestDTO;
import org.generation.socialNetwork.tours.model.TripBooking;

public class TripBookingMapper {

    private TripBookingMapper() {
    }

    public static TripBooking toEntity(TripBookingCreateRequestDTO dto) {
        TripBooking entity = new TripBooking();
        entity.setTourId(dto.getTourId());
        entity.setTouristId(dto.getTouristId());
        entity.setGuideId(dto.getGuideId());
        entity.setStartDatetime(dto.getStartDatetime());
        entity.setEndDatetime(dto.getEndDatetime());
        entity.setStatus(dto.getStatus());
        entity.setCancelReason(dto.getCancelReason());
        entity.setNotes(dto.getNotes());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }

    public static void updateEntity(TripBooking entity, TripBookingUpdateRequestDTO dto) {
        entity.setTourId(dto.getTourId());
        entity.setTouristId(dto.getTouristId());
        entity.setGuideId(dto.getGuideId());
        entity.setStartDatetime(dto.getStartDatetime());
        entity.setEndDatetime(dto.getEndDatetime());
        entity.setStatus(dto.getStatus());
        entity.setCancelReason(dto.getCancelReason());
        entity.setNotes(dto.getNotes());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
    }

    public static TripBookingResponseDTO toResponseDTO(TripBooking entity) {
        TripBookingResponseDTO dto = new TripBookingResponseDTO();
        dto.setTripId(entity.getTripId());
        dto.setTourId(entity.getTourId());
        dto.setTouristId(entity.getTouristId());
        dto.setGuideId(entity.getGuideId());
        dto.setStartDatetime(entity.getStartDatetime());
        dto.setEndDatetime(entity.getEndDatetime());
        dto.setStatus(entity.getStatus());
        dto.setCancelReason(entity.getCancelReason());
        dto.setNotes(entity.getNotes());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}