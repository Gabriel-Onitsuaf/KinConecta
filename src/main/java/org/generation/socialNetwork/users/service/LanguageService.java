package org.generation.socialNetwork.users.service;

import org.generation.socialNetwork.users.dto.LanguageCreateRequestDTO;
import org.generation.socialNetwork.users.dto.LanguageResponseDTO;
import org.generation.socialNetwork.users.dto.LanguageUpdateRequestDTO;

import java.util.List;

public interface LanguageService {

    LanguageResponseDTO create(LanguageCreateRequestDTO dto);

    LanguageResponseDTO update(String id, LanguageUpdateRequestDTO dto);

    LanguageResponseDTO findById(String id);

    List<LanguageResponseDTO> findAll();

    void delete(String id);
}