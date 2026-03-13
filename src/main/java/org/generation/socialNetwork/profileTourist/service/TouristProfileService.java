package org.generation.socialNetwork.profileTourist.service;

import org.generation.socialNetwork.profileTourist.dto.TouristProfileCreateRequestDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileResponseDTO;
import org.generation.socialNetwork.profileTourist.dto.TouristProfileUpdateRequestDTO;

import java.util.List;

public interface TouristProfileService {

    TouristProfileResponseDTO create(TouristProfileCreateRequestDTO dto);

    TouristProfileResponseDTO update(Long id, TouristProfileUpdateRequestDTO dto);

    TouristProfileResponseDTO findById(Long id);

    List<TouristProfileResponseDTO> findAll();

    void delete(Long id);
}