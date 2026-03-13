package org.generation.socialNetwork.faq.service;

import org.generation.socialNetwork.faq.dto.FaqCategoryCreateRequestDTO;
import org.generation.socialNetwork.faq.dto.FaqCategoryResponseDTO;
import org.generation.socialNetwork.faq.dto.FaqCategoryUpdateRequestDTO;
import org.generation.socialNetwork.faq.model.FaqCategory;

public class FaqCategoryMapper {

    private FaqCategoryMapper() {
    }

    public static FaqCategory toEntity(FaqCategoryCreateRequestDTO dto) {
        FaqCategory entity = new FaqCategory();
        entity.setName(dto.getName());
        entity.setRoleScope(dto.getRoleScope());
        entity.setSortOrder(dto.getSortOrder());
        return entity;
    }

    public static void updateEntity(FaqCategory entity, FaqCategoryUpdateRequestDTO dto) {
        entity.setName(dto.getName());
        entity.setRoleScope(dto.getRoleScope());
        entity.setSortOrder(dto.getSortOrder());
    }

    public static FaqCategoryResponseDTO toResponseDTO(FaqCategory entity) {
        FaqCategoryResponseDTO dto = new FaqCategoryResponseDTO();
        dto.setFaqCategoryId(entity.getFaqCategoryId());
        dto.setName(entity.getName());
        dto.setRoleScope(entity.getRoleScope());
        dto.setSortOrder(entity.getSortOrder());
        return dto;
    }
}