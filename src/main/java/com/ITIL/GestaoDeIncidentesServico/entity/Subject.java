package com.ITIL.GestaoDeIncidentesServico.entity;

import javax.jws.Oneway;
import javax.persistence.*;

@Entity
public class Subject {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String description;
    private Boolean active;
    private String timeToSolve;
    private String attendanceWindow;
    private String serviceWindow;
    @OneToOne
    private Category category;

    public Subject() {
    }

    public Subject(Integer id, String description, Boolean active, String timeToSolve, String attendanceWindow, String serviceWindow, Category category) {
        this.id = id;
        this.description = description;
        this.active = active;
        this.timeToSolve = timeToSolve;
        this.attendanceWindow = attendanceWindow;
        this.serviceWindow = serviceWindow;
        this.category = category;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getTimeToSolve() {
        return timeToSolve;
    }

    public void setTimeToSolve(String timeToSolve) {
        this.timeToSolve = timeToSolve;
    }

    public String getAttendanceWindow() {
        return attendanceWindow;
    }

    public void setAttendanceWindow(String attendanceWindow) {
        this.attendanceWindow = attendanceWindow;
    }

    public String getServiceWindow() {
        return serviceWindow;
    }

    public void setServiceWindow(String serviceWindow) {
        this.serviceWindow = serviceWindow;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
