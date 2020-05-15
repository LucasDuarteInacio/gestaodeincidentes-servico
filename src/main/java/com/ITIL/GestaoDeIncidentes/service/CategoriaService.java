package com.ITIL.GestaoDeIncidentes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ITIL.GestaoDeIncidentes.entity.Categoria;
import com.ITIL.GestaoDeIncidentes.exception.ApiException;
import com.ITIL.GestaoDeIncidentes.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	
	@Autowired
	CategoriaRepository repository;
	
	
	public Categoria addArea(Categoria area) {
		
		String descricaoValida = repository.findByDescricao(area.getDescricao());
		
		if(null != descricaoValida  ) {
			throw new  ApiException("Já existe uma area cadastrada com esse nome" ,"nome já cadastrado no sistema", HttpStatus.CONFLICT.value());
		}
		
		return repository.save(area);
	}
	
	public List<Categoria> findAll() {
		return repository.findAll();
	}

}
