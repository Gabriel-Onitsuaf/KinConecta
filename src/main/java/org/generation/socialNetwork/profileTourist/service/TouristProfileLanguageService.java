package org.generation.socialNetwork.profileTourist.service;

import org.generation.socialNetwork.profileTourist.dto.TouristProfileLanguageCreateRequestDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileLanguageResponseDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileLanguageUpdateRequestDTO;

import java.util.List;

public interface TouristProfileLanguageService {

    TouristProfileLanguageResponseDTO create(TouristProfileLanguageCreateRequestDTO dto);

    TouristProfileLanguageResponseDTO update(Long userId, String languageCode, TouristProfileLanguageUpdateRequestDTO dto);

    TouristProfileLanguageResponseDTO findById(Long userId, String languageCode);

    List<TouristProfileLanguageResponseDTO> findAll();

    void delete(Long userId, String languageCode);
}