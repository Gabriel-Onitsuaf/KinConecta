package org.generation.socialNetwork.users.repository;

import org.generation.socialNetwork.users.model.Language;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, String> {
}