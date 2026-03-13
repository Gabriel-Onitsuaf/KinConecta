package org.generation.socialNetwork.users.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.users.dto.LanguageCreateRequestDTO;
import org.generation.socialNetwork.users.dto.LanguageResponseDTO;
import org.generation.socialNetwork.users.dto.LanguageUpdateRequestDTO;
import org.generation.socialNetwork.users.model.Language;
import org.generation.socialNetwork.users.repository.LanguageRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Override
    public LanguageResponseDTO create(LanguageCreateRequestDTO dto) {

        Language entity = LanguageMapper.toEntity(dto);
        return LanguageMapper.toResponseDTO(languageRepository.save(entity));
    }

    @Override
    public LanguageResponseDTO update(String id, LanguageUpdateRequestDTO dto) {
        Language entity = languageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + id));

        LanguageMapper.updateEntity(entity, dto);
        return LanguageMapper.toResponseDTO(languageRepository.save(entity));
    }

    @Override
    public LanguageResponseDTO findById(String id) {
        return languageRepository.findById(id)
                .map(LanguageMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + id));
    }

    @Override
    public List<LanguageResponseDTO> findAll() {
        return languageRepository.findAll().stream()
                .map(LanguageMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(String id) {
        if (!languageRepository.existsById(id)) {
            throw new ResourceNotFoundException("Language not found with id: " + id);
        }
        languageRepository.deleteById(id);
    }


}