package com.ITIL.GestaoDeIncidentesServico.repository;

import com.ITIL.GestaoDeIncidentesServico.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {
}
