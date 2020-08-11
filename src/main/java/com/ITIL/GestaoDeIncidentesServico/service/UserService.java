package com.ITIL.GestaoDeIncidentesServico.service;

import java.util.List;
import java.util.Optional;

import com.ITIL.GestaoDeIncidentesServico.entity.Ticket;
import com.ITIL.GestaoDeIncidentesServico.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import  com.ITIL.GestaoDeIncidentesServico.entity.User;
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

	public User findById(Integer idUser) {
		Optional<User> ticket = repository.findById(idUser);
		return ticket.orElseThrow(() -> new ApiException("Usuario com id: " + idUser + " não encontrado!",
				"Tipo: " + User.class.getName(), HttpStatus.NOT_FOUND.value()));
	}

	public User register(User user) {
		user.setActive(true);

		Optional<String> opt;

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
