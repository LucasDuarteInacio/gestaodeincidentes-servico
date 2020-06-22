package com.ITIL.GestaoDeIncidentesServico.service;

import java.util.Date;
import java.util.List;

import com.ITIL.GestaoDeIncidentesServico.entity.Log;
import com.ITIL.GestaoDeIncidentesServico.entity.Ticket;
import com.ITIL.GestaoDeIncidentesServico.entity.User;
import com.ITIL.GestaoDeIncidentesServico.repository.TicketRepository;
import com.ITIL.GestaoDeIncidentesServico.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TicketService {
	
	@Autowired
	private TicketRepository repository;

	@Autowired
	private LogService logService;

	@Autowired
	private UserService userService;

	@Autowired
	private DateUtil dateUtil;


	public Ticket findById(Integer id) {
		return repository.findById(id).get();
	}
	
	public List<Ticket> findAll() {
		return repository.findAll();
	}
	
	public Ticket register(Ticket ticket) {
		Date date = new Date();
		ticket.setDate(date);
		Log log = logService.registerLog(ticket,"criou o ticket as: "+ dateUtil.dateToString(date),"Abertura");
		ticket.getLog().add(log);
		return repository.save(ticket);
	}


	public List<Ticket> openTickets(){
		String status = "Aberto";
		return repository.findByStatus(status);
	}

	public Ticket findTicketById(Integer id){
		return repository.findById(id).get();
	}

	public Ticket updateTicket(Ticket ticket) {
		Date date = new Date();
		Ticket editedTicket = repository.findById(ticket.getId()).get();

		editedTicket.setLevel(ticket.getLevel());
		editedTicket.setPriority(ticket.getPriority());
		editedTicket.setResponsible(ticket.getResponsible());
		editedTicket.setStatus(ticket.getStatus());

		Log log = addLogToStatus(editedTicket);
		editedTicket.getLog().add(log);

		return repository.save(editedTicket);
	}

	public Log addLogToStatus(Ticket ticket){
		Log log;
		if(ticket.getStatus().equals("Em andamento") ){
			return log = logService.registerLog(ticket,"Aceitou seu ticket","Abertura");
		}
		if(ticket.getStatus().equals("Finalizado") ){
			return log = logService.registerLog(ticket,"Finalizou seu ticket","Abertura");
		}
		return null;
	}

	public List<Ticket> findByUser(Integer idUser){
	User user = userService.findById(idUser);
	return repository.findByUser(user);
	}

	public List<Ticket> findByResponsible(Integer idUser){
		User user = userService.findById(idUser);
		return repository.findByResponsible(user);
	}

	public Ticket responsibleTransfer(Ticket ticket){
		Date date = new Date();
		Ticket editedTicket = repository.findById(ticket.getId()).get();
		editedTicket.setResponsible(ticket.getResponsible());

		User responsible = ticket.getResponsible();

		Log log = logService.registerLog(ticket,"seu ticket foi tranferido para o atendente " + responsible.getName(),"Abertura");
		editedTicket.getLog().add(log);

		return repository.save(editedTicket);
	}
}
