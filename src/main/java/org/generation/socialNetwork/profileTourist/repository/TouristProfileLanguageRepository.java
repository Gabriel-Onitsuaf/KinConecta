package org.generation.socialNetwork.profileTourist.repository;

import org.generation.socialNetwork.profileTourist.model.TouristProfileLanguage;
import org.generation.socialNetwork.profileTourist.model.TouristProfileLanguageId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristProfileLanguageRepository extends JpaRepository<TouristProfileLanguage, TouristProfileLanguageId> {
}