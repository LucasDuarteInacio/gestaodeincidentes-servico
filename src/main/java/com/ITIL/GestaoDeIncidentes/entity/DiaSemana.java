package com.ITIL.GestaoDeIncidentes.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DiaSemana {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String dia;
	private Date horaInicio;
	private Date horaFim;
	private Boolean ativo;
	
	public DiaSemana() {}
	
	public DiaSemana(Integer id, String dia, Date horaInicio, Date horaFim,Boolean ativo) {
		super();
		this.id = id;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.ativo = ativo;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public Date getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Date getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
}
