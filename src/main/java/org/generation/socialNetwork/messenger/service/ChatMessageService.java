package org.generation.socialNetwork.messenger.service;

import org.generation.socialNetwork.messenger.dto.ChatMessageCreateRequestDTO;
import org.generation.socialNetwork.messenger.dto.ChatMessageResponseDTO;
import org.generation.socialNetwork.messenger.dto.ChatMessageUpdateRequestDTO;

import java.util.List;

public interface ChatMessageService {

    ChatMessageResponseDTO create(ChatMessageCreateRequestDTO dto);

    ChatMessageResponseDTO update(Long id, ChatMessageUpdateRequestDTO dto);

    ChatMessageResponseDTO findById(Long id);

    List<ChatMessageResponseDTO> findAll();

    void delete(Long id);
}