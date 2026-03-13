package org.generation.socialNetwork.profileGuide.repository;

import org.generation.socialNetwork.profileGuide.model.IncomeTransaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeTransactionRepository extends JpaRepository<IncomeTransaction, Long> {
}