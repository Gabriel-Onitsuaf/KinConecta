package org.generation.socialNetwork.matching.service;

import org.generation.socialNetwork.matching.dto.FavoriteGuideCreateRequestDTO;
import org.generation.socialNetwork.matching.dto.FavoriteGuideResponseDTO;
import org.generation.socialNetwork.matching.dto.FavoriteGuideUpdateRequestDTO;

import java.util.List;

public interface FavoriteGuideService {

    FavoriteGuideResponseDTO create(FavoriteGuideCreateRequestDTO dto);

    FavoriteGuideResponseDTO update(Long touristId, Long guideId, FavoriteGuideUpdateRequestDTO dto);

    FavoriteGuideResponseDTO findById(Long touristId, Long guideId);

    List<FavoriteGuideResponseDTO> findAll();

    void delete(Long touristId, Long guideId);
}