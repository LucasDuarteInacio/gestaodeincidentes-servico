package com.ITIL.GestaoDeIncidentes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ITIL.GestaoDeIncidentes.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
	String findByDescricao(String descricao);

}
