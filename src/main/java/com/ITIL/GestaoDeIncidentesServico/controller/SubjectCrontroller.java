package com.ITIL.GestaoDeIncidentesServico.controller;

import java.util.List;

import com.ITIL.GestaoDeIncidentesServico.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITIL.GestaoDeIncidentesServico.entity.Subject;
import com.ITIL.GestaoDeIncidentesServico.service.SubjectService;

@CrossOrigin
@RestController
@RequestMapping("subject")
public class SubjectCrontroller {
	
	
	@Autowired
	SubjectService service;
	
	
	@PostMapping
	public Subject addSubject(@RequestBody Subject subject) {
		return service.registerSubject(subject);
	}
	
	@GetMapping
	public List<Subject> getSubject() {
		return service.findAllActive();
	}
	
	@PutMapping("/disable")
	public Subject delete(@RequestBody Subject subject) {
		return service.disabled(subject);
	}

	@PostMapping("/categorias")
	public  List<Subject> getSubjectByCategory(@RequestBody Category category){ return service.findSubjectByCategory(category); }


}
