package com.ITIL.GestaoDeIncidentesServico.repository;

import com.ITIL.GestaoDeIncidentesServico.entity.Ticket;
import com.ITIL.GestaoDeIncidentesServico.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findByStatus(String status);

    Optional<Ticket> findById(Integer id);

    List<Ticket> findByUser(User user);

    List<Ticket> findByResponsible(User responsible);


}
