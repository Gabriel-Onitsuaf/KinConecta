package org.generation.socialNetwork.reviews.repository;

import org.generation.socialNetwork.reviews.model.Review;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}