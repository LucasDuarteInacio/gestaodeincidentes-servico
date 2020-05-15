package com.ITIL.GestaoDeIncidentes.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Chamado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	private Usuario usuario;
	@OneToOne
	private Usuario responsavel;
	private Date data;
	private String titulo;
	private String descricao;
	@OneToOne
	private Sla sla;
	private String assunto;
	private String status;
	private Integer nivel;
	private String prioridade;
	@OneToMany
	private List<Log> mensagem;
	
	@OneToMany
	private List<Anexo> anexo  = new ArrayList<>();
	
	
	public Chamado() {}


	public Chamado(Integer id, Usuario usuario, Usuario responsavel, Date data, String titulo, String descricao,
			Sla sla, String assunto, String status, Integer nivel, String prioridade, List<Log> mensagem,
			List<Anexo> anexo) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.responsavel = responsavel;
		this.data = data;
		this.titulo = titulo;
		this.descricao = descricao;
		this.sla = sla;
		this.assunto = assunto;
		this.status = status;
		this.nivel = nivel;
		this.prioridade = prioridade;
		this.mensagem = mensagem;
		this.anexo = anexo;
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


	public Usuario getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Sla getSla() {
		return sla;
	}


	public void setSla(Sla sla) {
		this.sla = sla;
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


	public List<Log> getMensagem() {
		return mensagem;
	}


	public void setMensagem(List<Log> mensagem) {
		this.mensagem = mensagem;
	}


	public List<Anexo> getAnexo() {
		return anexo;
	}


	public void setAnexo(List<Anexo> anexo) {
		this.anexo = anexo;
	}


	

}
