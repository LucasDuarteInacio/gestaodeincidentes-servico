package com.ITIL.GestaoDeIncidentesServico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITIL.GestaoDeIncidentesServico.entity.User;
import com.ITIL.GestaoDeIncidentesServico.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		return service.register(user);
	}
	
	@GetMapping
	public List<User> getAll() {
		return service.findAll();
	}
	
	@GetMapping("active")
	public List<User> getAllActive() {
		return service.findAllActive();
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		return service.getLogin(user);
	}
	
	@PutMapping("disable")
	public User delete(@RequestBody User user) {
		return service.disabled(user);
	}
	
	@PutMapping("edit")
	public User edit(@RequestBody User user) {
		return service.userEdit(user);
	}
	
	@GetMapping("{idUser}")
	public User findUserById(@PathVariable("idUser") Integer id) {
		return service.findById(id);
	}
	

}
