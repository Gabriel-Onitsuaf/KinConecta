package org.generation.socialNetwork.messenger.service;

import org.generation.socialNetwork.messenger.model.ChatMessage;
import org.generation.socialNetwork.messenger.repository.ChatMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    public ChatMessage sendMessage(ChatMessage message) {

        message.setSentAt(LocalDateTime.now());

        return chatMessageRepository.save(message);
    }

    public List<ChatMessage> getMessagesByThread(Long threadId) {

        return chatMessageRepository.findByThreadId(threadId);
    }

}