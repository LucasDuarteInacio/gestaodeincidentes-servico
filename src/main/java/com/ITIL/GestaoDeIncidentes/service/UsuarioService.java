package com.ITIL.GestaoDeIncidentes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ITIL.GestaoDeIncidentes.entity.Usuario;
import com.ITIL.GestaoDeIncidentes.exception.ApiException;
import com.ITIL.GestaoDeIncidentes.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> findAll() {
		return repository.findByAtivo(true);
	}

	public Usuario findById(Integer id) {
		return repository.findById(id).get();
	}

	public Usuario register(Usuario usuario) {
		usuario.setAtivo(true);
		Optional<String> login = repository.findByLoginAndAtivo(usuario.getLogin(), usuario.getAtivo());

		if (login.isPresent()) {
			throw new ApiException("Ja existe um usuario cadastrado com esse login", "O login ja existe",
					HttpStatus.UNAUTHORIZED.value());
		}

		
		return repository.save(usuario);
	}

	public Usuario getLogin(Usuario usuario) {
		Optional<Usuario> opt = repository.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha());

		if (!opt.isPresent()) {
			throw new ApiException("usuario e/ou senha não existem", "Usuario ou senha inválidos",
					HttpStatus.NOT_FOUND.value());
		}

		return opt.get();

	}

	public Usuario disabled(Usuario user) {
		Usuario usuario = findById(user.getId());
		usuario.setAtivo(false);
		return repository.save(usuario);
	}

	public Usuario userEdit(Usuario user) {
		user.setAtivo(true);
		return repository.save(user);

	}

}
