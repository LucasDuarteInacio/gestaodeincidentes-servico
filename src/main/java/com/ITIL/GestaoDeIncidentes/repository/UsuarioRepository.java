package com.ITIL.GestaoDeIncidentes.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ITIL.GestaoDeIncidentes.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Query("Select u from Usuario u where u.login=?1 and u.senha=?2")
	Optional<Usuario> getlogin(String login, String senha);
	
	
	Optional<String> findByLogin(String login);
	
	

}
