package com.ITIL.GestaoDeIncidentes.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Calendario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	@OneToMany
	private List<DiaSemana> diaSemana;
	
	public Calendario() {}
	
	
	public Calendario(String descricao, List<DiaSemana> diaSemana) {
		super();
		this.descricao = descricao;
		this.diaSemana = diaSemana;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public List<DiaSemana> getDiaSemana() {
		return diaSemana;
	}


	public void setDiaSemana(List<DiaSemana> diaSemana) {
		this.diaSemana = diaSemana;
	}
	
	

	
}
