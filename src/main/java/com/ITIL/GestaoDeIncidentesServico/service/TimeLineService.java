package com.ITIL.GestaoDeIncidentesServico.service;

import com.ITIL.GestaoDeIncidentesServico.entity.TimeLine;
import com.ITIL.GestaoDeIncidentesServico.entity.Ticket;
import com.ITIL.GestaoDeIncidentesServico.entity.User;
import com.ITIL.GestaoDeIncidentesServico.repository.TimeLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TimeLineService {

    @Autowired
    private TimeLineRepository repository;

    public TimeLine registerLog(Ticket ticket, String message, String type ){
        Date date = new Date();
        User user = ticket.getUser();
        TimeLine log = new TimeLine(null, date ,message,type,user.getName());
        return repository.save(log);

    }

}
