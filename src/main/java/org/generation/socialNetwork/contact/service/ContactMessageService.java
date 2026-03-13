package org.generation.socialNetwork.contact.service;

import org.generation.socialNetwork.contact.dto.ContactMessageCreateRequestDTO;
import org.generation.socialNetwork.contact.dto.ContactMessageResponseDTO;
import org.generation.socialNetwork.contact.dto.ContactMessageUpdateRequestDTO;

import java.util.List;

public interface ContactMessageService {

    ContactMessageResponseDTO create(ContactMessageCreateRequestDTO dto);

    ContactMessageResponseDTO update(Long id, ContactMessageUpdateRequestDTO dto);

    ContactMessageResponseDTO findById(Long id);

    List<ContactMessageResponseDTO> findAll();

    void delete(Long id);
}