package com.ITIL.GestaoDeIncidentes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ITIL.GestaoDeIncidentes.entity.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
	
	String findByDescricao(String descricao);

}
