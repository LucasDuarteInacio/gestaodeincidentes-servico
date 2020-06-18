package com.ITIL.GestaoDeIncidentesServico.repository;

import com.ITIL.GestaoDeIncidentesServico.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findByDescriptionAndActive(String description, Boolean active);

    List<Category> findByActive(boolean active);
}
