package org.generation.socialNetwork.reviews.service;

import org.generation.socialNetwork.reviews.dto.ReviewCreateRequestDTO;
import org.generation.socialNetwork.reviews.dto.ReviewResponseDTO;
import org.generation.socialNetwork.reviews.dto.ReviewUpdateRequestDTO;

import java.util.List;

public interface ReviewService {

    ReviewResponseDTO create(ReviewCreateRequestDTO dto);

    ReviewResponseDTO update(Long id, ReviewUpdateRequestDTO dto);

    ReviewResponseDTO findById(Long id);

    List<ReviewResponseDTO> findAll();

    void delete(Long id);
}