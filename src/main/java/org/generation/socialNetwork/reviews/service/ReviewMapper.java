package org.generation.socialNetwork.reviews.service;

import org.generation.socialNetwork.reviews.dto.ReviewCreateRequestDTO;
import org.generation.socialNetwork.reviews.dto.ReviewResponseDTO;
import org.generation.socialNetwork.reviews.dto.ReviewUpdateRequestDTO;
import org.generation.socialNetwork.reviews.model.Review;

public class ReviewMapper {

    private ReviewMapper() {
    }

    public static Review toEntity(ReviewCreateRequestDTO dto) {
        Review entity = new Review();
        entity.setTripId(dto.getTripId());
        entity.setTourId(dto.getTourId());
        entity.setGuideId(dto.getGuideId());
        entity.setTouristId(dto.getTouristId());
        entity.setRating(dto.getRating());
        entity.setComment(dto.getComment());
        entity.setLikesCount(dto.getLikesCount());
        entity.setRepliesCount(dto.getRepliesCount());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setDeletedAt(dto.getDeletedAt());
        return entity;
    }

    public static void updateEntity(Review entity, ReviewUpdateRequestDTO dto) {
        entity.setTripId(dto.getTripId());
        entity.setTourId(dto.getTourId());
        entity.setGuideId(dto.getGuideId());
        entity.setTouristId(dto.getTouristId());
        entity.setRating(dto.getRating());
        entity.setComment(dto.getComment());
        entity.setLikesCount(dto.getLikesCount());
        entity.setRepliesCount(dto.getRepliesCount());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setDeletedAt(dto.getDeletedAt());
    }

    public static ReviewResponseDTO toResponseDTO(Review entity) {
        ReviewResponseDTO dto = new ReviewResponseDTO();
        dto.setReviewId(entity.getReviewId());
        dto.setTripId(entity.getTripId());
        dto.setTourId(entity.getTourId());
        dto.setGuideId(entity.getGuideId());
        dto.setTouristId(entity.getTouristId());
        dto.setRating(entity.getRating());
        dto.setComment(entity.getComment());
        dto.setLikesCount(entity.getLikesCount());
        dto.setRepliesCount(entity.getRepliesCount());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setDeletedAt(entity.getDeletedAt());
        return dto;
    }
}