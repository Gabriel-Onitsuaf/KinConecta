package org.generation.socialNetwork.contact.repository;

import org.generation.socialNetwork.contact.model.NewsletterSubscription;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsletterSubscriptionRepository extends JpaRepository<NewsletterSubscription, Long> {
}