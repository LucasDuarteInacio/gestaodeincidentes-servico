package com.ITIL.GestaoDeIncidentes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITIL.GestaoDeIncidentes.entity.Area;
import com.ITIL.GestaoDeIncidentes.service.AreaService;

@RestController
@RequestMapping("area")
public class AreaCrontroller {
	
	
	@Autowired
	AreaService service;
	
	
	@PostMapping
	public Area addArea(@RequestBody Area area) {
		return service.addArea(area);
	}
	
	@GetMapping
	public List<Area> getArea() {
		return service.findAll();
	}

}
