package org.generation.socialNetwork.matching.service;

import org.generation.socialNetwork.matching.dto.CompatibilityProfileCreateRequestDTO;
import org.generation.socialNetwork.matching.dto.CompatibilityProfileResponseDTO;
import org.generation.socialNetwork.matching.dto.CompatibilityProfileUpdateRequestDTO;
import org.generation.socialNetwork.matching.model.CompatibilityProfile;

public class CompatibilityProfileMapper {

    private CompatibilityProfileMapper() {
    }

    public static CompatibilityProfile toEntity(CompatibilityProfileCreateRequestDTO dto) {
        CompatibilityProfile entity = new CompatibilityProfile();
        entity.setUserId(dto.getUserId());
        entity.setRole(dto.getRole());
        entity.setName(dto.getName());
        entity.setImgUrl(dto.getImgUrl());
        entity.setDescription(dto.getDescription());
        entity.setEmail(dto.getEmail());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setPhoneCountryCode(dto.getPhoneCountryCode());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setPhoneE164(dto.getPhoneE164());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }

    public static void updateEntity(CompatibilityProfile entity, CompatibilityProfileUpdateRequestDTO dto) {
        entity.setUserId(dto.getUserId());
        entity.setRole(dto.getRole());
        entity.setName(dto.getName());
        entity.setImgUrl(dto.getImgUrl());
        entity.setDescription(dto.getDescription());
        entity.setEmail(dto.getEmail());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setPhoneCountryCode(dto.getPhoneCountryCode());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setPhoneE164(dto.getPhoneE164());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
    }

    public static CompatibilityProfileResponseDTO toResponseDTO(CompatibilityProfile entity) {
        CompatibilityProfileResponseDTO dto = new CompatibilityProfileResponseDTO();
        dto.setCompatibilityProfileId(entity.getCompatibilityProfileId());
        dto.setUserId(entity.getUserId());
        dto.setRole(entity.getRole());
        dto.setName(entity.getName());
        dto.setImgUrl(entity.getImgUrl());
        dto.setDescription(entity.getDescription());
        dto.setEmail(entity.getEmail());
        dto.setDateOfBirth(entity.getDateOfBirth());
        dto.setPhoneCountryCode(entity.getPhoneCountryCode());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setPhoneE164(entity.getPhoneE164());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}