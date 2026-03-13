package org.generation.socialNetwork.users.service;

import org.generation.socialNetwork.users.dto.UserCreateRequestDTO;
import org.generation.socialNetwork.users.dto.UserResponseDTO;
import org.generation.socialNetwork.users.dto.UserUpdateRequestDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO create(UserCreateRequestDTO dto);

    UserResponseDTO update(Long id, UserUpdateRequestDTO dto);

    UserResponseDTO findById(Long id);

    List<UserResponseDTO> findAll();

    void delete(Long id);
}