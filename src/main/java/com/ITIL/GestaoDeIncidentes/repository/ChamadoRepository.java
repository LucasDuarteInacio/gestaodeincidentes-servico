package com.ITIL.GestaoDeIncidentes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ITIL.GestaoDeIncidentes.entity.Chamado;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
