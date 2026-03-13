package org.generation.socialNetwork.faq.service;

import org.generation.socialNetwork.faq.dto.FaqCategoryCreateRequestDTO;
import org.generation.socialNetwork.faq.dto.FaqCategoryResponseDTO;
import org.generation.socialNetwork.faq.dto.FaqCategoryUpdateRequestDTO;

import java.util.List;

public interface FaqCategoryService {

    FaqCategoryResponseDTO create(FaqCategoryCreateRequestDTO dto);

    FaqCategoryResponseDTO update(Integer id, FaqCategoryUpdateRequestDTO dto);

    FaqCategoryResponseDTO findById(Integer id);

    List<FaqCategoryResponseDTO> findAll();

    void delete(Integer id);
}