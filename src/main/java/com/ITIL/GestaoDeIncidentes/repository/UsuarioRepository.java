package com.ITIL.GestaoDeIncidentes.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ITIL.GestaoDeIncidentes.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	
	 
	Optional<Usuario> findByLoginAndSenha(String login,String senha);
	
	
	Optional<String> findByLoginAndAtivo(String login,Boolean ativo);
	
	List<Usuario> findByAtivo(Boolean ativo);
	
	
	
	

}
