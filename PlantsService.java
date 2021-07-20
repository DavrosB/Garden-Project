package com.qa.spring.garden.service;

// imports from javax
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.spring.garden.domain.Plants;
import com.qa.spring.garden.repo.PlantsRepo;

import java.util.List;


@Service //this handles the business logic

public class PlantsService {
	
//	Dependency - service is dependent on the repo
	
	public PlantsRepo repo;
	
	public PlantsService(PlantsRepo repo ) {
		this.repo = repo;
	}
	
//	Now create the CRUD methods for interaction between controller and repo
	
//	CREATE is first
	
	public Plants create(Plants plant) {
		return this.repo.saveAndFlush(plant);
	}
	
	
//	READ is next
	public List<Plants> read(){
		return this.repo.findAll(); 
	}
	
//	UPDATE is next
	public Plants update(Long id, Plants newPlant) {
//		// GET THE RECORD THAT LIVES IN THE DB
		Plants existing = this.repo.getById(id); 
		existing.setPlantName(newPlant.getPlantName());
		existing.setPlantType(newPlant.getPlantType());
		existing.setDecorative(newPlant.isDecorative());
		Plants updated = this.repo.save(existing);
		return updated;
	}
	
//	DELETE is next
	
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id); 
		
	}
	
	

}
