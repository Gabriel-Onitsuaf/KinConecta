package org.generation.socialNetwork.contact.service;

import org.generation.socialNetwork.contact.dto.NewsletterSubscriptionCreateRequestDTO;
import org.generation.socialNetwork.contact.dto.NewsletterSubscriptionResponseDTO;
import org.generation.socialNetwork.contact.dto.NewsletterSubscriptionUpdateRequestDTO;
import org.generation.socialNetwork.contact.model.NewsletterSubscription;

public class NewsletterSubscriptionMapper {

    private NewsletterSubscriptionMapper() {
    }

    public static NewsletterSubscription toEntity(NewsletterSubscriptionCreateRequestDTO dto) {
        NewsletterSubscription entity = new NewsletterSubscription();
        entity.setEmail(dto.getEmail());
        entity.setSourcePage(dto.getSourcePage());
        entity.setIsActive(dto.getIsActive());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUnsubscribedAt(dto.getUnsubscribedAt());
        return entity;
    }

    public static void updateEntity(NewsletterSubscription entity, NewsletterSubscriptionUpdateRequestDTO dto) {
        entity.setEmail(dto.getEmail());
        entity.setSourcePage(dto.getSourcePage());
        entity.setIsActive(dto.getIsActive());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUnsubscribedAt(dto.getUnsubscribedAt());
    }

    public static NewsletterSubscriptionResponseDTO toResponseDTO(NewsletterSubscription entity) {
        NewsletterSubscriptionResponseDTO dto = new NewsletterSubscriptionResponseDTO();
        dto.setSubscriptionId(entity.getSubscriptionId());
        dto.setEmail(entity.getEmail());
        dto.setSourcePage(entity.getSourcePage());
        dto.setIsActive(entity.getIsActive());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUnsubscribedAt(entity.getUnsubscribedAt());
        return dto;
    }
}