package com.ITIL.GestaoDeIncidentes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITIL.GestaoDeIncidentes.entity.Usuario;
import com.ITIL.GestaoDeIncidentes.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	@PostMapping
	public Usuario addUser(@RequestBody Usuario usuario) {
		return service.register(usuario);
	}
	
	@GetMapping
	public List<Usuario> getAll() {
		return service.findAll();
		
	}
	
	@PostMapping("/login")
	public Usuario login(@RequestBody Usuario usuario) {
		return service.getLogin(usuario);
	}
	

}
