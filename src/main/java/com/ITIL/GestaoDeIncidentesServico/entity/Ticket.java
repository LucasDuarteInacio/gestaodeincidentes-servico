package com.ITIL.GestaoDeIncidentesServico.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private User user;
    @OneToOne
    private User responsible;
    private Date date;
    @OneToOne
    private Subject subject;
    private String description;
    private String status;
    private String level;
    private String priority;
    @OneToMany
    private List<TimeLine> timeLine = new ArrayList<>();

    @OneToMany
    private List<Archive> archive = new ArrayList<>();

}