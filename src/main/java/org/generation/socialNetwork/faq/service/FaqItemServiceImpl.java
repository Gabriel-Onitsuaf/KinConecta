package org.generation.socialNetwork.faq.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.faq.dto.FaqItemCreateRequestDTO;
import org.generation.socialNetwork.faq.dto.FaqItemResponseDTO;
import org.generation.socialNetwork.faq.dto.FaqItemUpdateRequestDTO;
import org.generation.socialNetwork.faq.model.FaqItem;
import org.generation.socialNetwork.faq.repository.FaqCategoryRepository;
import org.generation.socialNetwork.faq.repository.FaqItemRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FaqItemServiceImpl implements FaqItemService {

    private final FaqItemRepository faqItemRepository;
    private final FaqCategoryRepository faqCategoryRepository;

    @Override
    public FaqItemResponseDTO create(FaqItemCreateRequestDTO dto) {
        validateFaqCategoryExists(dto.getFaqCategoryId(), "faqCategoryId");
        FaqItem entity = FaqItemMapper.toEntity(dto);
        return FaqItemMapper.toResponseDTO(faqItemRepository.save(entity));
    }

    @Override
    public FaqItemResponseDTO update(Long id, FaqItemUpdateRequestDTO dto) {
        FaqItem entity = faqItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FaqItem not found with id: " + id));
        validateFaqCategoryExists(dto.getFaqCategoryId(), "faqCategoryId");
        FaqItemMapper.updateEntity(entity, dto);
        return FaqItemMapper.toResponseDTO(faqItemRepository.save(entity));
    }

    @Override
    public FaqItemResponseDTO findById(Long id) {
        return faqItemRepository.findById(id)
                .map(FaqItemMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("FaqItem not found with id: " + id));
    }

    @Override
    public List<FaqItemResponseDTO> findAll() {
        return faqItemRepository.findAll().stream()
                .map(FaqItemMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!faqItemRepository.existsById(id)) {
            throw new ResourceNotFoundException("FaqItem not found with id: " + id);
        }
        faqItemRepository.deleteById(id);
    }

    private void validateFaqCategoryExists(Integer id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!faqCategoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("FaqCategory not found for " + fieldName + ": " + id);
        }
    }
}