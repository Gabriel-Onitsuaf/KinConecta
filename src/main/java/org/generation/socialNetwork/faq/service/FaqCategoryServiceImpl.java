package org.generation.socialNetwork.faq.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.faq.dto.FaqCategoryCreateRequestDTO;
import org.generation.socialNetwork.faq.dto.FaqCategoryResponseDTO;
import org.generation.socialNetwork.faq.dto.FaqCategoryUpdateRequestDTO;
import org.generation.socialNetwork.faq.model.FaqCategory;
import org.generation.socialNetwork.faq.repository.FaqCategoryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FaqCategoryServiceImpl implements FaqCategoryService {

    private final FaqCategoryRepository faqCategoryRepository;

    @Override
    public FaqCategoryResponseDTO create(FaqCategoryCreateRequestDTO dto) {

        FaqCategory entity = FaqCategoryMapper.toEntity(dto);
        return FaqCategoryMapper.toResponseDTO(faqCategoryRepository.save(entity));
    }

    @Override
    public FaqCategoryResponseDTO update(Integer id, FaqCategoryUpdateRequestDTO dto) {
        FaqCategory entity = faqCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FaqCategory not found with id: " + id));

        FaqCategoryMapper.updateEntity(entity, dto);
        return FaqCategoryMapper.toResponseDTO(faqCategoryRepository.save(entity));
    }

    @Override
    public FaqCategoryResponseDTO findById(Integer id) {
        return faqCategoryRepository.findById(id)
                .map(FaqCategoryMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("FaqCategory not found with id: " + id));
    }

    @Override
    public List<FaqCategoryResponseDTO> findAll() {
        return faqCategoryRepository.findAll().stream()
                .map(FaqCategoryMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Integer id) {
        if (!faqCategoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("FaqCategory not found with id: " + id);
        }
        faqCategoryRepository.deleteById(id);
    }


}