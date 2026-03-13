package org.generation.socialNetwork.tours.service;

import org.generation.socialNetwork.tours.dto.TourDestinationCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TourDestinationResponseDTO;
import org.generation.socialNetwork.tours.dto.TourDestinationUpdateRequestDTO;

import java.util.List;

public interface TourDestinationService {

    TourDestinationResponseDTO create(TourDestinationCreateRequestDTO dto);

    TourDestinationResponseDTO update(Long tourId, Long destinationId, TourDestinationUpdateRequestDTO dto);

    TourDestinationResponseDTO findById(Long tourId, Long destinationId);

    List<TourDestinationResponseDTO> findAll();

    void delete(Long tourId, Long destinationId);
}