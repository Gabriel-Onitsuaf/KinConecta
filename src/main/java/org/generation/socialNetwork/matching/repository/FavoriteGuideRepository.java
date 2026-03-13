package org.generation.socialNetwork.matching.repository;

import org.generation.socialNetwork.matching.model.FavoriteGuide;
import org.generation.socialNetwork.matching.model.FavoriteGuideId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteGuideRepository extends JpaRepository<FavoriteGuide, FavoriteGuideId> {
}