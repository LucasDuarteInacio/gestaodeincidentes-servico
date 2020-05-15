package com.ITIL.GestaoDeIncidentes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ITIL.GestaoDeIncidentes.entity.Usuario;
import com.ITIL.GestaoDeIncidentes.service.UsuarioService;

@CrossOrigin
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
	
	@PutMapping("desativar")
	public Usuario delete(@RequestBody Usuario usuario) {
		return service.disabled(usuario);
	}
	
	@PutMapping("editar")
	public Usuario editar(@RequestBody Usuario usuario) {
		return service.userEdit(usuario);
	}
	
	@GetMapping("{idUser}")
	public Usuario findUserById(@PathVariable("idUser") Integer id) {
		return service.findById(id);
	}
	

}
