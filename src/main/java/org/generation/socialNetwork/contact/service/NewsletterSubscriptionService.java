package org.generation.socialNetwork.contact.service;

import org.generation.socialNetwork.contact.dto.NewsletterSubscriptionCreateRequestDTO;
import org.generation.socialNetwork.contact.dto.NewsletterSubscriptionResponseDTO;
import org.generation.socialNetwork.contact.dto.NewsletterSubscriptionUpdateRequestDTO;

import java.util.List;

public interface NewsletterSubscriptionService {

    NewsletterSubscriptionResponseDTO create(NewsletterSubscriptionCreateRequestDTO dto);

    NewsletterSubscriptionResponseDTO update(Long id, NewsletterSubscriptionUpdateRequestDTO dto);

    NewsletterSubscriptionResponseDTO findById(Long id);

    List<NewsletterSubscriptionResponseDTO> findAll();

    void delete(Long id);
}