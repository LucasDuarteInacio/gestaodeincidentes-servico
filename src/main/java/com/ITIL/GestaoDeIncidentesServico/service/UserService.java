package com.ITIL.GestaoDeIncidentesServico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import  com.ITIL.GestaoDeIncidentesServico.entity.Level;
import  com.ITIL.GestaoDeIncidentesServico.entity.User;
import  com.ITIL.GestaoDeIncidentesServico.exception.ApiException;
import  com.ITIL.GestaoDeIncidentesServico.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAllActive() {
		return repository.findByActive(true);
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Integer id) {
		return repository.findById(id).get();
	}

	public User register(User user) {
		user.setActive(true);

		Level nivel = user.getLevel();

		Optional<String> opt;

		if ( user.getProfile() == "usuario") {
			throw new ApiException("O perfil 'usuario' nao pode ser setado como: " + nivel.getDescription(),
					"O nivel setado na classe usuario esta incorreto", HttpStatus.BAD_GATEWAY.value());
		}

		opt = repository.findByLoginAndActive(user.getLogin(), user.getActive());

		if (opt.isPresent()) {
			throw new ApiException("Ja existe um usuario cadastrado com esse login", "O login ja existe",
					HttpStatus.UNAUTHORIZED.value());
		}

		return repository.save(user);
	}

	public User getLogin(User user) {
		Optional<User> login = repository.findByLoginAndPassword(user.getLogin(), user.getPassword());

		if (!login.isPresent()) {
			throw new ApiException("usuario e/ou senha não existem", "Usuario ou senha inválidos",
					HttpStatus.NOT_FOUND.value());
		}

		return login.get();

	}

	public User disabled(User idUser) {
		User user = findById(idUser.getId());
		user.setActive(false);
		return repository.save(user);
	}

	public User userEdit(User user) {
		user.setActive(true);
		return repository.save(user);

	}

}
