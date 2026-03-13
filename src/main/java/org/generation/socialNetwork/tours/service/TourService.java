package org.generation.socialNetwork.tours.service;

import org.generation.socialNetwork.tours.dto.TourCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TourResponseDTO;
import org.generation.socialNetwork.tours.dto.TourUpdateRequestDTO;

import java.util.List;

public interface TourService {

    TourResponseDTO create(TourCreateRequestDTO dto);

    TourResponseDTO update(Long id, TourUpdateRequestDTO dto);

    TourResponseDTO findById(Long id);

    List<TourResponseDTO> findAll();

    void delete(Long id);
}