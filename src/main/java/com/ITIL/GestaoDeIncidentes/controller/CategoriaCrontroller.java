package com.ITIL.GestaoDeIncidentes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITIL.GestaoDeIncidentes.entity.Categoria;
import com.ITIL.GestaoDeIncidentes.service.CategoriaService;

@RestController
@RequestMapping("categoria")
public class CategoriaCrontroller {
	
	
	@Autowired
	CategoriaService service;
	
	
	@PostMapping
	public Categoria addArea(@RequestBody Categoria area) {
		return service.addArea(area);
	}
	
	@GetMapping
	public List<Categoria> getArea() {
		return service.findAll();
	}

}
