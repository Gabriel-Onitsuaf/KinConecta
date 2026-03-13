package org.generation.socialNetwork.notifications.repository;

import org.generation.socialNetwork.notifications.model.Notification;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}