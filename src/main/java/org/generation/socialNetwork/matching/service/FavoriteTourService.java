package org.generation.socialNetwork.matching.service;

import org.generation.socialNetwork.matching.dto.FavoriteTourCreateRequestDTO;
import org.generation.socialNetwork.matching.dto.FavoriteTourResponseDTO;
import org.generation.socialNetwork.matching.dto.FavoriteTourUpdateRequestDTO;

import java.util.List;

public interface FavoriteTourService {

    FavoriteTourResponseDTO create(FavoriteTourCreateRequestDTO dto);

    FavoriteTourResponseDTO update(Long touristId, Long tourId, FavoriteTourUpdateRequestDTO dto);

    FavoriteTourResponseDTO findById(Long touristId, Long tourId);

    List<FavoriteTourResponseDTO> findAll();

    void delete(Long touristId, Long tourId);
}