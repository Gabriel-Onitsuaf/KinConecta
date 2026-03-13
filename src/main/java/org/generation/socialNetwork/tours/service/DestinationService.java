package org.generation.socialNetwork.tours.service;

import org.generation.socialNetwork.tours.dto.DestinationCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.DestinationResponseDTO;
import org.generation.socialNetwork.tours.dto.DestinationUpdateRequestDTO;

import java.util.List;

public interface DestinationService {

    DestinationResponseDTO create(DestinationCreateRequestDTO dto);

    DestinationResponseDTO update(Long id, DestinationUpdateRequestDTO dto);

    DestinationResponseDTO findById(Long id);

    List<DestinationResponseDTO> findAll();

    void delete(Long id);
}