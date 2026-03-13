package org.generation.socialNetwork.contact.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.contact.dto.NewsletterSubscriptionCreateRequestDTO;
import org.generation.socialNetwork.contact.dto.NewsletterSubscriptionResponseDTO;
import org.generation.socialNetwork.contact.dto.NewsletterSubscriptionUpdateRequestDTO;
import org.generation.socialNetwork.contact.model.NewsletterSubscription;
import org.generation.socialNetwork.contact.repository.NewsletterSubscriptionRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewsletterSubscriptionServiceImpl implements NewsletterSubscriptionService {

    private final NewsletterSubscriptionRepository newsletterSubscriptionRepository;

    @Override
    public NewsletterSubscriptionResponseDTO create(NewsletterSubscriptionCreateRequestDTO dto) {

        NewsletterSubscription entity = NewsletterSubscriptionMapper.toEntity(dto);
        return NewsletterSubscriptionMapper.toResponseDTO(newsletterSubscriptionRepository.save(entity));
    }

    @Override
    public NewsletterSubscriptionResponseDTO update(Long id, NewsletterSubscriptionUpdateRequestDTO dto) {
        NewsletterSubscription entity = newsletterSubscriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("NewsletterSubscription not found with id: " + id));

        NewsletterSubscriptionMapper.updateEntity(entity, dto);
        return NewsletterSubscriptionMapper.toResponseDTO(newsletterSubscriptionRepository.save(entity));
    }

    @Override
    public NewsletterSubscriptionResponseDTO findById(Long id) {
        return newsletterSubscriptionRepository.findById(id)
                .map(NewsletterSubscriptionMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("NewsletterSubscription not found with id: " + id));
    }

    @Override
    public List<NewsletterSubscriptionResponseDTO> findAll() {
        return newsletterSubscriptionRepository.findAll().stream()
                .map(NewsletterSubscriptionMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!newsletterSubscriptionRepository.existsById(id)) {
            throw new ResourceNotFoundException("NewsletterSubscription not found with id: " + id);
        }
        newsletterSubscriptionRepository.deleteById(id);
    }


}