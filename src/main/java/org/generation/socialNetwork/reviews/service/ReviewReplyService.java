package org.generation.socialNetwork.reviews.service;

import org.generation.socialNetwork.reviews.dto.ReviewReplyCreateRequestDTO;
import org.generation.socialNetwork.reviews.dto.ReviewReplyResponseDTO;
import org.generation.socialNetwork.reviews.dto.ReviewReplyUpdateRequestDTO;

import java.util.List;

public interface ReviewReplyService {

    ReviewReplyResponseDTO create(ReviewReplyCreateRequestDTO dto);

    ReviewReplyResponseDTO update(Long id, ReviewReplyUpdateRequestDTO dto);

    ReviewReplyResponseDTO findById(Long id);

    List<ReviewReplyResponseDTO> findAll();

    void delete(Long id);
}