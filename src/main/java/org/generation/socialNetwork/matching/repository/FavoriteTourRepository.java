package org.generation.socialNetwork.matching.repository;

import org.generation.socialNetwork.matching.model.FavoriteTour;
import org.generation.socialNetwork.matching.model.FavoriteTourId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteTourRepository extends JpaRepository<FavoriteTour, FavoriteTourId> {
}