package org.generation.socialNetwork.tours.repository;

import org.generation.socialNetwork.tours.model.TripStatusHistory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TripStatusHistoryRepository extends JpaRepository<TripStatusHistory, Long> {
}