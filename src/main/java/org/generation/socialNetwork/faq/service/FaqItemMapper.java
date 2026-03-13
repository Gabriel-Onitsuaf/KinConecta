package org.generation.socialNetwork.faq.service;

import org.generation.socialNetwork.faq.dto.FaqItemCreateRequestDTO;
import org.generation.socialNetwork.faq.dto.FaqItemResponseDTO;
import org.generation.socialNetwork.faq.dto.FaqItemUpdateRequestDTO;
import org.generation.socialNetwork.faq.model.FaqItem;

public class FaqItemMapper {

    private FaqItemMapper() {
    }

    public static FaqItem toEntity(FaqItemCreateRequestDTO dto) {
        FaqItem entity = new FaqItem();
        entity.setFaqCategoryId(dto.getFaqCategoryId());
        entity.setQuestion(dto.getQuestion());
        entity.setAnswer(dto.getAnswer());
        entity.setIsActive(dto.getIsActive());
        entity.setSortOrder(dto.getSortOrder());
        return entity;
    }

    public static void updateEntity(FaqItem entity, FaqItemUpdateRequestDTO dto) {
        entity.setFaqCategoryId(dto.getFaqCategoryId());
        entity.setQuestion(dto.getQuestion());
        entity.setAnswer(dto.getAnswer());
        entity.setIsActive(dto.getIsActive());
        entity.setSortOrder(dto.getSortOrder());
    }

    public static FaqItemResponseDTO toResponseDTO(FaqItem entity) {
        FaqItemResponseDTO dto = new FaqItemResponseDTO();
        dto.setFaqItemId(entity.getFaqItemId());
        dto.setFaqCategoryId(entity.getFaqCategoryId());
        dto.setQuestion(entity.getQuestion());
        dto.setAnswer(entity.getAnswer());
        dto.setIsActive(entity.getIsActive());
        dto.setSortOrder(entity.getSortOrder());
        return dto;
    }
}