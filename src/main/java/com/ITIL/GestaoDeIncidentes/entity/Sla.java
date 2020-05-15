package com.ITIL.GestaoDeIncidentes.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sla {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@OneToMany
	private List<Categoria> categoria;
	private String tipo;
	private Date tempoLimite;
	
	public Sla() {};
	
	public Sla(String nome, List<Categoria> categoria, String tipo, Date tempoLimite) {
		super();
		this.nome = nome;
		this.categoria = categoria;
		this.tipo = tipo;
		this.tempoLimite = tempoLimite;
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getTempoLimite() {
		return tempoLimite;
	}

	public void setTempoLimite(Date tempoLimite) {
		this.tempoLimite = tempoLimite;
	}
	
	
	
	

}
