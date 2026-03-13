package org.generation.socialNetwork.contact.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.contact.dto.ContactMessageCreateRequestDTO;
import org.generation.socialNetwork.contact.dto.ContactMessageResponseDTO;
import org.generation.socialNetwork.contact.dto.ContactMessageUpdateRequestDTO;
import org.generation.socialNetwork.contact.model.ContactMessage;
import org.generation.socialNetwork.contact.repository.ContactMessageRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactMessageServiceImpl implements ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;

    @Override
    public ContactMessageResponseDTO create(ContactMessageCreateRequestDTO dto) {

        ContactMessage entity = ContactMessageMapper.toEntity(dto);
        return ContactMessageMapper.toResponseDTO(contactMessageRepository.save(entity));
    }

    @Override
    public ContactMessageResponseDTO update(Long id, ContactMessageUpdateRequestDTO dto) {
        ContactMessage entity = contactMessageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ContactMessage not found with id: " + id));

        ContactMessageMapper.updateEntity(entity, dto);
        return ContactMessageMapper.toResponseDTO(contactMessageRepository.save(entity));
    }

    @Override
    public ContactMessageResponseDTO findById(Long id) {
        return contactMessageRepository.findById(id)
                .map(ContactMessageMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("ContactMessage not found with id: " + id));
    }

    @Override
    public List<ContactMessageResponseDTO> findAll() {
        return contactMessageRepository.findAll().stream()
                .map(ContactMessageMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!contactMessageRepository.existsById(id)) {
            throw new ResourceNotFoundException("ContactMessage not found with id: " + id);
        }
        contactMessageRepository.deleteById(id);
    }


}