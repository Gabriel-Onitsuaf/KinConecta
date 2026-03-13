package org.generation.socialNetwork.users.service;

import org.generation.socialNetwork.users.dto.AuthSessionCreateRequestDTO;
import org.generation.socialNetwork.users.dto.AuthSessionResponseDTO;
import org.generation.socialNetwork.users.dto.AuthSessionUpdateRequestDTO;

import java.util.List;

public interface AuthSessionService {

    AuthSessionResponseDTO create(AuthSessionCreateRequestDTO dto);

    AuthSessionResponseDTO update(Long id, AuthSessionUpdateRequestDTO dto);

    AuthSessionResponseDTO findById(Long id);

    List<AuthSessionResponseDTO> findAll();

    void delete(Long id);
}