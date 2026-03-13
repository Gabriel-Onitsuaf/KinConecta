package org.generation.socialNetwork.profileTourist.service;

import org.generation.socialNetwork.profileTourist.dto.InterestCreateRequestDTO;
import org.generation.socialNetwork.profileTourist.dto.InterestResponseDTO;
import org.generation.socialNetwork.profileTourist.dto.InterestUpdateRequestDTO;
import org.generation.socialNetwork.profileTourist.model.Interest;

public class InterestMapper {

    private InterestMapper() {
    }

    public static Interest toEntity(InterestCreateRequestDTO dto) {
        Interest entity = new Interest();
        entity.setName(dto.getName());
        return entity;
    }

    public static void updateEntity(Interest entity, InterestUpdateRequestDTO dto) {
        entity.setName(dto.getName());
    }

    public static InterestResponseDTO toResponseDTO(Interest entity) {
        InterestResponseDTO dto = new InterestResponseDTO();
        dto.setInterestId(entity.getInterestId());
        dto.setName(entity.getName());
        return dto;
    }
}