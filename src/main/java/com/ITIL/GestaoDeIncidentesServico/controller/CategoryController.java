package com.ITIL.GestaoDeIncidentesServico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITIL.GestaoDeIncidentesServico.entity.Category;
import com.ITIL.GestaoDeIncidentesServico.service.CategoryService;

@CrossOrigin
@RestController
@RequestMapping("category")
public class CategoryController {

	
	
	@Autowired
	private CategoryService service;
	
	@PostMapping
	public Category addCategory(@RequestBody Category category) {
		return service.registerCategory(category);
	}
	
	@GetMapping
	public List<Category> getSubject() {
		return service.findAllActive();
	}
	
	@PutMapping("disable")
	public Category delete(@RequestBody Category category) {
		return service.disabled(category);
	}

}
