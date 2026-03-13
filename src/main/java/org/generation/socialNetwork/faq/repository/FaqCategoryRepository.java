package org.generation.socialNetwork.faq.repository;

import org.generation.socialNetwork.faq.model.FaqCategory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqCategoryRepository extends JpaRepository<FaqCategory, Integer> {
}