package com.ITIL.GestaoDeIncidentesServico.service;

import java.util.List;
import java.util.Optional;

import com.ITIL.GestaoDeIncidentesServico.entity.Category;
import com.ITIL.GestaoDeIncidentesServico.exception.ApiException;
import com.ITIL.GestaoDeIncidentesServico.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;



@Service
public class CategoryService {

	
	@Autowired
	private CategoryRepository repository;
	
	public Category findById(Integer idCategory){
		Optional<Category> category = repository.findById(idCategory);
		return category.orElseThrow(() -> new ApiException("Categoria com id: " + idCategory + " não encontrado!",
				"Tipo: " + Category.class.getName(), HttpStatus.NOT_FOUND.value()));
	}

	public Category registerCategory(Category category){
		
		category.setActive(true);
		Optional<Category> opt;
		opt = repository.findByDescriptionAndActive(category.getDescription(), category.getActive());

		if (opt.isPresent()) {
			throw new ApiException("Já existe uma area cadastrada com esse nome", "nome já cadastrado no sistema",
					HttpStatus.CONFLICT.value());
		}

		return repository.save(category);
		
	}
	
	public List<Category> findAllActive() {
		return repository.findByActive(true);
	}
	
	public Category disabled(Category obj) {
		Category category = findById(obj.getId());
		category.setActive(false);
		return repository.save(category);
	}
}
