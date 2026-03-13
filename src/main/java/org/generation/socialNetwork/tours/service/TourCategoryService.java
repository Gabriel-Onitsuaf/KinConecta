package org.generation.socialNetwork.tours.service;

import org.generation.socialNetwork.tours.dto.TourCategoryCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TourCategoryResponseDTO;
import org.generation.socialNetwork.tours.dto.TourCategoryUpdateRequestDTO;

import java.util.List;

public interface TourCategoryService {

    TourCategoryResponseDTO create(TourCategoryCreateRequestDTO dto);

    TourCategoryResponseDTO update(Integer id, TourCategoryUpdateRequestDTO dto);

    TourCategoryResponseDTO findById(Integer id);

    List<TourCategoryResponseDTO> findAll();

    void delete(Integer id);
}