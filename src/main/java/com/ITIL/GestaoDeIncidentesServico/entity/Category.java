package com.ITIL.GestaoDeIncidentesServico.entity;

import javax.persistence.*;
import java.util.List;



@Entity
public class Category {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	private Boolean active;

	
	
	public Category() {}

	public Category(Integer id, String description, Boolean active, List<Subject> subject) {
		this.id = id;
		this.description = description;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
