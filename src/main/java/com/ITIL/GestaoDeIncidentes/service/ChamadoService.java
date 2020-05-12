package com.ITIL.GestaoDeIncidentes.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITIL.GestaoDeIncidentes.entity.Chamado;
import com.ITIL.GestaoDeIncidentes.repository.ChamadoRepository;

@Service
public class ChamadoService {
	
	@Autowired
	private ChamadoRepository repository;
	
	public Chamado findById(Integer id) {
		return repository.findById(id).get();
	}
	
	public List<Chamado> findAll() {
		return repository.findAll();
	}
	
	public Chamado register(Chamado chamado) {
		chamado.setData(new Date());
		return repository.save(chamado);
	}
	
}
