package org.generation.socialNetwork.tours.service;

import org.generation.socialNetwork.tours.dto.TourIncludedItemCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TourIncludedItemResponseDTO;
import org.generation.socialNetwork.tours.dto.TourIncludedItemUpdateRequestDTO;

import java.util.List;

public interface TourIncludedItemService {

    TourIncludedItemResponseDTO create(TourIncludedItemCreateRequestDTO dto);

    TourIncludedItemResponseDTO update(Long id, TourIncludedItemUpdateRequestDTO dto);

    TourIncludedItemResponseDTO findById(Long id);

    List<TourIncludedItemResponseDTO> findAll();

    void delete(Long id);
}