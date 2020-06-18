package com.ITIL.GestaoDeIncidentesServico.service;

import java.util.Date;
import java.util.List;

import com.ITIL.GestaoDeIncidentesServico.entity.Ticket;
import com.ITIL.GestaoDeIncidentesServico.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TicketService {
	
	@Autowired
	private TicketRepository repository;
	
	public Ticket findById(Integer id) {
		return repository.findById(id).get();
	}
	
	public List<Ticket> findAll() {
		return repository.findAll();
	}
	
	public Ticket register(Ticket ticket) {
		ticket.setDate(new Date());
		return repository.save(ticket);
	}
	
}
