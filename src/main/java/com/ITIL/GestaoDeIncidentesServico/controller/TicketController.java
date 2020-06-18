package com.ITIL.GestaoDeIncidentesServico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITIL.GestaoDeIncidentesServico.entity.Ticket;
import com.ITIL.GestaoDeIncidentesServico.service.TicketService;

@RestController
@RequestMapping("ticket")
public class TicketController {
	
	@Autowired
	private TicketService service;
	
	
	@GetMapping
	public List<Ticket> getAll() {
		return service.findAll();
	}
	
	@PostMapping
	public Ticket newTicket(@RequestBody Ticket ticket) {
		return service.register(ticket);
		
	}

}
