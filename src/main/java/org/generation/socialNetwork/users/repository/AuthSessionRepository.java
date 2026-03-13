package org.generation.socialNetwork.users.repository;

import org.generation.socialNetwork.users.model.AuthSession;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthSessionRepository extends JpaRepository<AuthSession, Long> {
}