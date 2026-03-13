package org.generation.socialNetwork.faq.service;

import org.generation.socialNetwork.faq.dto.FaqItemCreateRequestDTO;
import org.generation.socialNetwork.faq.dto.FaqItemResponseDTO;
import org.generation.socialNetwork.faq.dto.FaqItemUpdateRequestDTO;

import java.util.List;

public interface FaqItemService {

    FaqItemResponseDTO create(FaqItemCreateRequestDTO dto);

    FaqItemResponseDTO update(Long id, FaqItemUpdateRequestDTO dto);

    FaqItemResponseDTO findById(Long id);

    List<FaqItemResponseDTO> findAll();

    void delete(Long id);
}