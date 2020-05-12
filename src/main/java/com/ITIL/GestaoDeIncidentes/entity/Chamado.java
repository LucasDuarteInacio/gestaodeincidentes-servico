package com.ITIL.GestaoDeIncidentes.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Chamado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	private Usuario usuario;
	private Date data;
	private String descricao;
	@OneToOne
	private Area area;
	private String assunto;
	private String status;
	private Integer nivel;
	private String prioridade;
	@OneToMany
	private List<Chat> mensagem;
	
	public Chamado() {}
	
	public Chamado(Usuario usuario, Date data, String descricao, Area area, String assunto, String status,
			Integer nivel, String prioridade, List<Chat> mensagem) {
		super();
		this.usuario = usuario;
		this.data = data;
		this.descricao = descricao;
		this.area = area;
		this.assunto = assunto;
		this.status = status;
		this.nivel = nivel;
		this.prioridade = prioridade;
		this.mensagem = mensagem;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public List<Chat> getMensagem() {
		return mensagem;
	}

	public void setMensagem(List<Chat> mensagem) {
		this.mensagem = mensagem;
	}
	
	
	

}
