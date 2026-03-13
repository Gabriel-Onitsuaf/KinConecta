package org.generation.socialNetwork.help.repository;

import org.generation.socialNetwork.help.model.SupportTicket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> {
}