package com.ITIL.GestaoDeIncidentesServico.service;

import com.ITIL.GestaoDeIncidentesServico.entity.Log;
import com.ITIL.GestaoDeIncidentesServico.entity.Ticket;
import com.ITIL.GestaoDeIncidentesServico.entity.User;
import com.ITIL.GestaoDeIncidentesServico.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LogService {

    @Autowired
    private LogRepository repository;

    public Log registerLog(Ticket ticket,String message,String type ){
        Date date = new Date();
        User user = ticket.getUser();
        Log log = new Log(null, date ,message,type,user.getName());
        return repository.save(log);

    }

}
