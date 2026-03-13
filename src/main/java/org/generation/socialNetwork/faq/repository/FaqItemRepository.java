package org.generation.socialNetwork.faq.repository;

import org.generation.socialNetwork.faq.model.FaqItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqItemRepository extends JpaRepository<FaqItem, Long> {
}