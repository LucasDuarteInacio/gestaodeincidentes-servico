package com.ITIL.GestaoDeIncidentesServico.repository;

import com.ITIL.GestaoDeIncidentesServico.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
