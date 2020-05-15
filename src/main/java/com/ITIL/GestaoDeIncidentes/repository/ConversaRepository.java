package com.ITIL.GestaoDeIncidentes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ITIL.GestaoDeIncidentes.entity.Log;

@Repository
public interface ConversaRepository extends JpaRepository<Log, Integer> {

}
