package com.ITIL.GestaoDeIncidentes.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Chat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date data;
	private String mensagem;
	@OneToOne
	private Usuario ususario;
	
	
	public Chat() {}
	
	public Chat(Date data, String mensagem, Usuario ususario) {
		this.data = data;
		this.mensagem = mensagem;
		this.ususario = ususario;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Usuario getUsusario() {
		return ususario;
	}
	public void setUsusario(Usuario ususario) {
		this.ususario = ususario;
	}
	
	
	

}
