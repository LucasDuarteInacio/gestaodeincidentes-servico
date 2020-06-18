package com.ITIL.GestaoDeIncidentesServico.service;


import com.ITIL.GestaoDeIncidentesServico.entity.Category;
import com.ITIL.GestaoDeIncidentesServico.entity.Subject;
import com.ITIL.GestaoDeIncidentesServico.exception.ApiException;
import com.ITIL.GestaoDeIncidentesServico.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

	@Autowired
	SubjectRepository repository;

	public Subject registerSubject(Subject subject) {
		subject.setActive(true);
		Optional<Subject> opt;
		opt = repository.findByDescriptionAndActive(subject.getDescription(), subject.getActive());

		if (opt.isPresent()) {
			throw new ApiException("Já existe um assunto cadastrado com esse nome", "nome já cadastrado no sistema",
					HttpStatus.CONFLICT.value());
		}

		return repository.save(subject);
	}

	public List<Subject> findAll() {
		return repository.findAll();
	}

	public List<Subject> findAllActive() {
		return repository.findByActive(true);
	}

	public Subject disabled(Subject idSubject) {
		Subject subject = repository.findById(idSubject.getId()).get();
		subject.setActive(false);
		return repository.save(subject);
	}

	public List<Subject> findSubjectByCategory(Category category){
		return repository.findByCategory(category);
	}
}
