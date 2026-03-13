package org.generation.socialNetwork.reviews.service;

import org.generation.socialNetwork.reviews.dto.ReviewReplyCreateRequestDTO;
import org.generation.socialNetwork.reviews.dto.ReviewReplyResponseDTO;
import org.generation.socialNetwork.reviews.dto.ReviewReplyUpdateRequestDTO;
import org.generation.socialNetwork.reviews.model.ReviewReply;

public class ReviewReplyMapper {

    private ReviewReplyMapper() {
    }

    public static ReviewReply toEntity(ReviewReplyCreateRequestDTO dto) {
        ReviewReply entity = new ReviewReply();
        entity.setReviewId(dto.getReviewId());
        entity.setGuideId(dto.getGuideId());
        entity.setMessage(dto.getMessage());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }

    public static void updateEntity(ReviewReply entity, ReviewReplyUpdateRequestDTO dto) {
        entity.setReviewId(dto.getReviewId());
        entity.setGuideId(dto.getGuideId());
        entity.setMessage(dto.getMessage());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
    }

    public static ReviewReplyResponseDTO toResponseDTO(ReviewReply entity) {
        ReviewReplyResponseDTO dto = new ReviewReplyResponseDTO();
        dto.setReplyId(entity.getReplyId());
        dto.setReviewId(entity.getReviewId());
        dto.setGuideId(entity.getGuideId());
        dto.setMessage(entity.getMessage());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}