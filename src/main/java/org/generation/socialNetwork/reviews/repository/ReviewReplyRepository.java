package org.generation.socialNetwork.reviews.repository;

import org.generation.socialNetwork.reviews.model.ReviewReply;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewReplyRepository extends JpaRepository<ReviewReply, Long> {
}