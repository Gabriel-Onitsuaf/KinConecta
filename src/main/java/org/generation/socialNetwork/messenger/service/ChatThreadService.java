package org.generation.socialNetwork.messenger.service;

import org.generation.socialNetwork.messenger.dto.ChatThreadCreateRequestDTO;
import org.generation.socialNetwork.messenger.dto.ChatThreadResponseDTO;
import org.generation.socialNetwork.messenger.dto.ChatThreadUpdateRequestDTO;

import java.util.List;

public interface ChatThreadService {

    ChatThreadResponseDTO create(ChatThreadCreateRequestDTO dto);

    ChatThreadResponseDTO update(Long id, ChatThreadUpdateRequestDTO dto);

    ChatThreadResponseDTO findById(Long id);

    List<ChatThreadResponseDTO> findAll();

    void delete(Long id);
}