package com.ITIL.GestaoDeIncidentesServico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public Ticket newTicket(@RequestBody Ticket ticket) { return service.register(ticket);}

	@GetMapping("open")
	public List<Ticket> openTickets(){ return service.openTickets(); }

	@GetMapping("{id}")
	public Ticket getTicketById(@PathVariable("id") Integer id){
		return service.findTicketById(id);
	}

	@PostMapping("update")
	public Ticket updateTicket(@RequestBody Ticket ticket){ return service.updateTicket(ticket);}

	@GetMapping("user/{idUser}")
	public List<Ticket> getByUser(@PathVariable("idUser") Integer idUser){return service.findByUser(idUser);}

	@GetMapping("responsible/{idUser}")
	public List<Ticket> getByResponsible(@PathVariable("idUser") Integer idUser){return service.findByResponsible(idUser);}

	@PostMapping("transfer")
	public Ticket responsibleTransfer(@RequestBody Ticket ticket) {return service.responsibleTransfer(ticket);}
}
