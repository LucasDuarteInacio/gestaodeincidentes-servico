package com.ITIL.GestaoDeIncidentesServico.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.jws.Oneway;
import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subject {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private Boolean active;
    private String timeToSolve;
    private String attendanceWindow;
    private String serviceWindow;
    @OneToOne
    private Category category;

}