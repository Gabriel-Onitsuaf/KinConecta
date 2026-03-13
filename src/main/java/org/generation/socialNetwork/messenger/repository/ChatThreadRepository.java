package org.generation.socialNetwork.messenger.repository;

import org.generation.socialNetwork.messenger.model.ChatThread;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatThreadRepository extends JpaRepository<ChatThread, Long> {
}