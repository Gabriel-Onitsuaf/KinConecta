package org.generation.socialNetwork.profileTourist.service;

import org.generation.socialNetwork.profileTourist.dto.TouristProfileCreateRequestDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileResponseDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileUpdateRequestDTO;
import org.generation.socialNetwork.profileTourist.model.TouristProfile;

public class TouristProfileMapper {

    private TouristProfileMapper() {
    }

    public static TouristProfile toEntity(TouristProfileCreateRequestDTO dto) {
        TouristProfile entity = new TouristProfile();
        entity.setUserId(dto.getUserId());
        entity.setLocation(dto.getLocation());
        entity.setBio(dto.getBio());
        entity.setMemberSince(dto.getMemberSince());
        entity.setBadge(dto.getBadge());
        entity.setTravelStyle(dto.getTravelStyle());
        entity.setTripType(dto.getTripType());
        entity.setPaceAndCompany(dto.getPaceAndCompany());
        entity.setActivityLevel(dto.getActivityLevel());
        entity.setGroupPreference(dto.getGroupPreference());
        entity.setDietaryPreferences(dto.getDietaryPreferences());
        entity.setPlanningLevel(dto.getPlanningLevel());
        entity.setAmenities(dto.getAmenities());
        entity.setTransport(dto.getTransport());
        entity.setPhotoPreference(dto.getPhotoPreference());
        entity.setAccessibility(dto.getAccessibility());
        entity.setAdditionalNotes(dto.getAdditionalNotes());
        entity.setAvatarUrl(dto.getAvatarUrl());
        entity.setCoverUrl(dto.getCoverUrl());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }

    public static void updateEntity(TouristProfile entity, TouristProfileUpdateRequestDTO dto) {
        entity.setLocation(dto.getLocation());
        entity.setBio(dto.getBio());
        entity.setMemberSince(dto.getMemberSince());
        entity.setBadge(dto.getBadge());
        entity.setTravelStyle(dto.getTravelStyle());
        entity.setTripType(dto.getTripType());
        entity.setPaceAndCompany(dto.getPaceAndCompany());
        entity.setActivityLevel(dto.getActivityLevel());
        entity.setGroupPreference(dto.getGroupPreference());
        entity.setDietaryPreferences(dto.getDietaryPreferences());
        entity.setPlanningLevel(dto.getPlanningLevel());
        entity.setAmenities(dto.getAmenities());
        entity.setTransport(dto.getTransport());
        entity.setPhotoPreference(dto.getPhotoPreference());
        entity.setAccessibility(dto.getAccessibility());
        entity.setAdditionalNotes(dto.getAdditionalNotes());
        entity.setAvatarUrl(dto.getAvatarUrl());
        entity.setCoverUrl(dto.getCoverUrl());
        entity.setUpdatedAt(dto.getUpdatedAt());
    }

    public static TouristProfileResponseDTO toResponseDTO(TouristProfile entity) {
        TouristProfileResponseDTO dto = new TouristProfileResponseDTO();
        dto.setUserId(entity.getUserId());
        dto.setLocation(entity.getLocation());
        dto.setBio(entity.getBio());
        dto.setMemberSince(entity.getMemberSince());
        dto.setBadge(entity.getBadge());
        dto.setTravelStyle(entity.getTravelStyle());
        dto.setTripType(entity.getTripType());
        dto.setPaceAndCompany(entity.getPaceAndCompany());
        dto.setActivityLevel(entity.getActivityLevel());
        dto.setGroupPreference(entity.getGroupPreference());
        dto.setDietaryPreferences(entity.getDietaryPreferences());
        dto.setPlanningLevel(entity.getPlanningLevel());
        dto.setAmenities(entity.getAmenities());
        dto.setTransport(entity.getTransport());
        dto.setPhotoPreference(entity.getPhotoPreference());
        dto.setAccessibility(entity.getAccessibility());
        dto.setAdditionalNotes(entity.getAdditionalNotes());
        dto.setAvatarUrl(entity.getAvatarUrl());
        dto.setCoverUrl(entity.getCoverUrl());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}