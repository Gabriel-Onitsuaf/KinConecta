package org.generation.socialNetwork.reviews.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.reviews.dto.ReviewReplyCreateRequestDTO;
import org.generation.socialNetwork.reviews.dto.ReviewReplyResponseDTO;
import org.generation.socialNetwork.reviews.dto.ReviewReplyUpdateRequestDTO;
import org.generation.socialNetwork.reviews.model.ReviewReply;
import org.generation.socialNetwork.reviews.repository.ReviewReplyRepository;
import org.generation.socialNetwork.reviews.repository.ReviewRepository;
import org.generation.socialNetwork.users.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewReplyServiceImpl implements ReviewReplyService {

    private final ReviewReplyRepository reviewReplyRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    @Override
    public ReviewReplyResponseDTO create(ReviewReplyCreateRequestDTO dto) {
        validateReviewExists(dto.getReviewId(), "reviewId");
        validateUserExists(dto.getGuideId(), "guideId");
        ReviewReply entity = ReviewReplyMapper.toEntity(dto);
        return ReviewReplyMapper.toResponseDTO(reviewReplyRepository.save(entity));
    }

    @Override
    public ReviewReplyResponseDTO update(Long id, ReviewReplyUpdateRequestDTO dto) {
        ReviewReply entity = reviewReplyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ReviewReply not found with id: " + id));
        validateReviewExists(dto.getReviewId(), "reviewId");
        validateUserExists(dto.getGuideId(), "guideId");
        ReviewReplyMapper.updateEntity(entity, dto);
        return ReviewReplyMapper.toResponseDTO(reviewReplyRepository.save(entity));
    }

    @Override
    public ReviewReplyResponseDTO findById(Long id) {
        return reviewReplyRepository.findById(id)
                .map(ReviewReplyMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("ReviewReply not found with id: " + id));
    }

    @Override
    public List<ReviewReplyResponseDTO> findAll() {
        return reviewReplyRepository.findAll().stream()
                .map(ReviewReplyMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!reviewReplyRepository.existsById(id)) {
            throw new ResourceNotFoundException("ReviewReply not found with id: " + id);
        }
        reviewReplyRepository.deleteById(id);
    }

    private void validateReviewExists(Long id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!reviewRepository.existsById(id)) {
            throw new ResourceNotFoundException("Review not found for " + fieldName + ": " + id);
        }
    }
    private void validateUserExists(Long id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found for " + fieldName + ": " + id);
        }
    }
}