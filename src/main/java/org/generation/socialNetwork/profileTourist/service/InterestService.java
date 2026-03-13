package org.generation.socialNetwork.profileTourist.service;

import org.generation.socialNetwork.profileTourist.dto.InterestCreateRequestDTO;
import org.generation.socialNetwork.profileTourist.dto.InterestResponseDTO;
import org.generation.socialNetwork.profileTourist.dto.InterestUpdateRequestDTO;

import java.util.List;

public interface InterestService {

    InterestResponseDTO create(InterestCreateRequestDTO dto);

    InterestResponseDTO update(Integer id, InterestUpdateRequestDTO dto);

    InterestResponseDTO findById(Integer id);

    List<InterestResponseDTO> findAll();

    void delete(Integer id);
}