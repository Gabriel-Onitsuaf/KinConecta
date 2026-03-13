package org.generation.socialNetwork.messenger.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.messenger.dto.ChatMessageCreateRequestDTO;
import org.generation.socialNetwork.messenger.dto.ChatMessageResponseDTO;
import org.generation.socialNetwork.messenger.dto.ChatMessageUpdateRequestDTO;
import org.generation.socialNetwork.messenger.model.ChatMessage;
import org.generation.socialNetwork.messenger.repository.ChatMessageRepository;
import org.generation.socialNetwork.messenger.repository.ChatThreadRepository;
import org.generation.socialNetwork.users.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatThreadRepository chatThreadRepository;
    private final UserRepository userRepository;

    @Override
    public ChatMessageResponseDTO create(ChatMessageCreateRequestDTO dto) {
        validateChatThreadExists(dto.getThreadId(), "threadId");
        validateUserExists(dto.getSenderUserId(), "senderUserId");
        ChatMessage entity = ChatMessageMapper.toEntity(dto);
        return ChatMessageMapper.toResponseDTO(chatMessageRepository.save(entity));
    }

    @Override
    public ChatMessageResponseDTO update(Long id, ChatMessageUpdateRequestDTO dto) {
        ChatMessage entity = chatMessageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ChatMessage not found with id: " + id));
        validateChatThreadExists(dto.getThreadId(), "threadId");
        validateUserExists(dto.getSenderUserId(), "senderUserId");
        ChatMessageMapper.updateEntity(entity, dto);
        return ChatMessageMapper.toResponseDTO(chatMessageRepository.save(entity));
    }

    @Override
    public ChatMessageResponseDTO findById(Long id) {
        return chatMessageRepository.findById(id)
                .map(ChatMessageMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("ChatMessage not found with id: " + id));
    }

    @Override
    public List<ChatMessageResponseDTO> findAll() {
        return chatMessageRepository.findAll().stream()
                .map(ChatMessageMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!chatMessageRepository.existsById(id)) {
            throw new ResourceNotFoundException("ChatMessage not found with id: " + id);
        }
        chatMessageRepository.deleteById(id);
    }

    private void validateChatThreadExists(Long id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!chatThreadRepository.existsById(id)) {
            throw new ResourceNotFoundException("ChatThread not found for " + fieldName + ": " + id);
        }
    }
    private void validateUserExists(Long id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found for " + fieldName + ": " + id);
        }
    }
}