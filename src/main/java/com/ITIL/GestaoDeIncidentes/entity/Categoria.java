package com.ITIL.GestaoDeIncidentes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	@OneToOne
	private Calendario calendario;
		
	
	public Categoria() {}


	public Categoria(String descricao, Calendario calendario) {
		super();
		this.descricao = descricao;
		this.calendario = calendario;
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


	public Calendario getCalendario() {
		return calendario;
	}


	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}
	
	

	

	

}
