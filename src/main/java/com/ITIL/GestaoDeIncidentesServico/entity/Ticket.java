package com.ITIL.GestaoDeIncidentesServico.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private List<Log> log = new ArrayList<>();
    @OneToMany
    private List<Archive> archive;

    public Ticket() {
    }

    public Ticket(Integer id, User user, User responsible, Date date, Subject subject, String description, String status, String level, String priority, List<Log> log, List<Archive> archive) {
        this.id = id;
        this.user = user;
        this.responsible = responsible;
        this.date = date;
        this.subject = subject;
        this.description = description;
        this.status = status;
        this.level = level;
        this.priority = priority;
        this.log = log;
        this.archive = archive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) { this.date = date; }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public List<Log> getLog() {
        return log;
    }

    public void setLog(List<Log> log) {
        this.log = log;
    }

    public List<Archive> getArchive() {
        return archive;
    }

    public void setArchive(List<Archive> archive) {
        this.archive = archive;
    }
}
