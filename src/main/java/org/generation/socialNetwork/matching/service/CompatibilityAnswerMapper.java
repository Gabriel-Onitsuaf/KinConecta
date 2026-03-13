package org.generation.socialNetwork.matching.service;

import org.generation.socialNetwork.matching.dto.CompatibilityAnswerCreateRequestDTO;
import org.generation.socialNetwork.matching.dto.CompatibilityAnswerResponseDTO;
import org.generation.socialNetwork.matching.dto.CompatibilityAnswerUpdateRequestDTO;
import org.generation.socialNetwork.matching.model.CompatibilityAnswer;

public class CompatibilityAnswerMapper {

    private CompatibilityAnswerMapper() {
    }

    public static CompatibilityAnswer toEntity(CompatibilityAnswerCreateRequestDTO dto) {
        CompatibilityAnswer entity = new CompatibilityAnswer();
        entity.setCompatibilityProfileId(dto.getCompatibilityProfileId());
        entity.setQuestionKey(dto.getQuestionKey());
        entity.setValueText(dto.getValueText());
        entity.setValueNumber(dto.getValueNumber());
        entity.setValueJson(dto.getValueJson());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }

    public static void updateEntity(CompatibilityAnswer entity, CompatibilityAnswerUpdateRequestDTO dto) {
        entity.setCompatibilityProfileId(dto.getCompatibilityProfileId());
        entity.setQuestionKey(dto.getQuestionKey());
        entity.setValueText(dto.getValueText());
        entity.setValueNumber(dto.getValueNumber());
        entity.setValueJson(dto.getValueJson());
        entity.setCreatedAt(dto.getCreatedAt());
    }

    public static CompatibilityAnswerResponseDTO toResponseDTO(CompatibilityAnswer entity) {
        CompatibilityAnswerResponseDTO dto = new CompatibilityAnswerResponseDTO();
        dto.setAnswerId(entity.getAnswerId());
        dto.setCompatibilityProfileId(entity.getCompatibilityProfileId());
        dto.setQuestionKey(entity.getQuestionKey());
        dto.setValueText(entity.getValueText());
        dto.setValueNumber(entity.getValueNumber());
        dto.setValueJson(entity.getValueJson());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}