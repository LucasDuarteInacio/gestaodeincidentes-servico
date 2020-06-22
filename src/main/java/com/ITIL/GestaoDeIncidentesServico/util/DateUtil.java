package com.ITIL.GestaoDeIncidentesServico.util;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateUtil {

    private DateUtil(){

    }


    public  String dateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateFormated = dateFormat.format(date);
        return dateFormated;
    }


}

