package org.generation.socialNetwork.tours.service;

import org.generation.socialNetwork.tours.dto.TourCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TourResponseDTO;
import org.generation.socialNetwork.tours.dto.TourUpdateRequestDTO;
import org.generation.socialNetwork.tours.model.Tour;

public class TourMapper {

    private TourMapper() {
    }

    public static Tour toEntity(TourCreateRequestDTO dto) {
        Tour entity = new Tour();
        entity.setGuideId(dto.getGuideId());
        entity.setCategoryId(dto.getCategoryId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setCurrency(dto.getCurrency());
        entity.setDurationHours(dto.getDurationHours());
        entity.setMaxGroupSize(dto.getMaxGroupSize());
        entity.setMeetingPoint(dto.getMeetingPoint());
        entity.setStatus(dto.getStatus());
        entity.setCoverImageUrl(dto.getCoverImageUrl());
        entity.setImageClass(dto.getImageClass());
        entity.setRatingAvg(dto.getRatingAvg());
        entity.setBookingsCount(dto.getBookingsCount());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }

    public static void updateEntity(Tour entity, TourUpdateRequestDTO dto) {
        entity.setGuideId(dto.getGuideId());
        entity.setCategoryId(dto.getCategoryId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setCurrency(dto.getCurrency());
        entity.setDurationHours(dto.getDurationHours());
        entity.setMaxGroupSize(dto.getMaxGroupSize());
        entity.setMeetingPoint(dto.getMeetingPoint());
        entity.setStatus(dto.getStatus());
        entity.setCoverImageUrl(dto.getCoverImageUrl());
        entity.setImageClass(dto.getImageClass());
        entity.setRatingAvg(dto.getRatingAvg());
        entity.setBookingsCount(dto.getBookingsCount());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
    }

    public static TourResponseDTO toResponseDTO(Tour entity) {
        TourResponseDTO dto = new TourResponseDTO();
        dto.setTourId(entity.getTourId());
        dto.setGuideId(entity.getGuideId());
        dto.setCategoryId(entity.getCategoryId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setCurrency(entity.getCurrency());
        dto.setDurationHours(entity.getDurationHours());
        dto.setMaxGroupSize(entity.getMaxGroupSize());
        dto.setMeetingPoint(entity.getMeetingPoint());
        dto.setStatus(entity.getStatus());
        dto.setCoverImageUrl(entity.getCoverImageUrl());
        dto.setImageClass(entity.getImageClass());
        dto.setRatingAvg(entity.getRatingAvg());
        dto.setBookingsCount(entity.getBookingsCount());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}