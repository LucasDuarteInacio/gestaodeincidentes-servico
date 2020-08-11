package com.ITIL.GestaoDeIncidentesServico.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.ITIL.GestaoDeIncidentesServico.entity.Subject;
import com.ITIL.GestaoDeIncidentesServico.entity.TimeLine;
import com.ITIL.GestaoDeIncidentesServico.entity.Ticket;
import com.ITIL.GestaoDeIncidentesServico.entity.User;
import com.ITIL.GestaoDeIncidentesServico.exception.ApiException;
import com.ITIL.GestaoDeIncidentesServico.repository.TicketRepository;
import com.ITIL.GestaoDeIncidentesServico.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;



@Service
public class TicketService {
	
	@Autowired
	private TicketRepository repository;

	@Autowired
	private TimeLineService timeLineService;

	@Autowired
	private UserService userService;

	@Autowired
	private DateUtil dateUtil;


	public Ticket findById(Integer idTicket) {
		Optional<Ticket> ticket = repository.findById(idTicket);
		return ticket.orElseThrow(() -> new ApiException("Chamado com id: " + idTicket + " não encontrado!",
				"Tipo: " + Ticket.class.getName(), HttpStatus.NOT_FOUND.value()));
	}
	
	public List<Ticket> findAll() {
		return repository.findAll();
	}
	
	public Ticket register(Ticket ticket) {
		Date date = new Date();
		ticket.setDate(date);
		TimeLine timeLine = timeLineService.registerLog(ticket,"criou o ticket as: "+ dateUtil.dateToString(date),"Abertura");
		ticket.getTimeLine().add(timeLine);
		return repository.save(ticket);
	}


	public List<Ticket> openTickets(){
		String status = "Aberto";
		return repository.findByStatus(status);
	}



	public Ticket updateTicket(Ticket ticket) {
		Date date = new Date();
		Ticket editedTicket = findById(ticket.getId());

		editedTicket.setLevel(ticket.getLevel());
		editedTicket.setPriority(ticket.getPriority());
		editedTicket.setResponsible(ticket.getResponsible());
		editedTicket.setStatus(ticket.getStatus());

		TimeLine log = addLogToStatus(editedTicket);
		editedTicket.getTimeLine().add(log);

		return repository.save(editedTicket);
	}

	public TimeLine addLogToStatus(Ticket ticket){
		TimeLine log;
		if(ticket.getStatus().equals("Em andamento") ){
			return log = timeLineService.registerLog(ticket,"Aceitou seu ticket","Abertura");
		}
		if(ticket.getStatus().equals("Finalizado") ){
			return log = timeLineService.registerLog(ticket,"Finalizou seu ticket","Abertura");
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
		Ticket editedTicket = findById(ticket.getId());
		editedTicket.setResponsible(ticket.getResponsible());

		User responsible = ticket.getResponsible();

		TimeLine log = timeLineService.registerLog(ticket,"seu ticket foi tranferido para o atendente " + responsible.getName(),"Abertura");
		editedTicket.getTimeLine().add(log);

		return repository.save(editedTicket);
	}
}
