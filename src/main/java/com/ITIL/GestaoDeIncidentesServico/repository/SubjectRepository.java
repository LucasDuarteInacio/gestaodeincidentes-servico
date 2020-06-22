package com.ITIL.GestaoDeIncidentesServico.repository;

import com.ITIL.GestaoDeIncidentesServico.entity.Category;
import com.ITIL.GestaoDeIncidentesServico.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    Optional<Subject> findByDescriptionAndActive(String description, Boolean active);

    List<Subject> findByActive(Boolean active);

    List<Subject> findByCategory(Category category);




}
