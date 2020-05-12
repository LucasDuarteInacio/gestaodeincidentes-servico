package com.ITIL.GestaoDeIncidentes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITIL.GestaoDeIncidentes.entity.Chamado;
import com.ITIL.GestaoDeIncidentes.service.ChamadoService;

@RestController
@RequestMapping("chamado")
public class ChamadoController {
	
	@Autowired
	private ChamadoService service;
	
	
	@GetMapping
	public List<Chamado> getAll() {
		return service.findAll();
	}
	
	@PostMapping
	public Chamado newChamado(@RequestBody Chamado chamado) {
		return service.register(chamado);
		
	}

}
