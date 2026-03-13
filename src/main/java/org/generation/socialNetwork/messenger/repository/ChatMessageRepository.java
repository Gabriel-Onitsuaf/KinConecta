package org.generation.socialNetwork.messenger.repository;

import org.generation.socialNetwork.messenger.model.ChatMessage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}