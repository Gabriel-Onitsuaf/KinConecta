package org.generation.socialNetwork.profileTourist.service;

import org.generation.socialNetwork.profileTourist.dto.TouristProfileInterestCreateRequestDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileInterestResponseDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileInterestUpdateRequestDTO;

import java.util.List;

public interface TouristProfileInterestService {

    TouristProfileInterestResponseDTO create(TouristProfileInterestCreateRequestDTO dto);

    TouristProfileInterestResponseDTO update(Long userId, Integer interestId, TouristProfileInterestUpdateRequestDTO dto);

    TouristProfileInterestResponseDTO findById(Long userId, Integer interestId);

    List<TouristProfileInterestResponseDTO> findAll();

    void delete(Long userId, Integer interestId);
}