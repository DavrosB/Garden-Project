package com.qa.spring.garden.controller;


// import java stuff
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.spring.garden.domain.Plants;
import com.qa.spring.garden.service.PlantsService;


@CrossOrigin
@RestController  //this handles the requests
@RequestMapping("/plants") //this will map our path to http://localhost:9092/plants/.....

public class PlantsController {

//	add dependency on service class
//	Dependency
	private PlantsService service;
	
//	next we need to connect the controller and the service 
//	we use Autowired to achieve this
	
	@Autowired
	public PlantsController(PlantsService service) {
		this.service = service;
	}
	
	
//	Now add the @GetMapping elements - first do a test map
//	hover over @getMapping and import from javax
	@GetMapping("/test")
	public String test() {
	return "This is a test to read the plants"; 
	}
	
	
//	CRUD - Create, Read, Update, Delete
	
//	Create first - needs to use @PostMapping and specify the 
//	added http element
	@PostMapping("/createplant")
	public ResponseEntity<Plants> create(@RequestBody Plants plant) {
		return new ResponseEntity<Plants>(this.service.create(plant), HttpStatus.CREATED);
	
	}
	
//	create READ next - use @GetMapping and http element
	@GetMapping("/read")
	public ResponseEntity<List<Plants>> read(){
		return new ResponseEntity<List<Plants>>( this.service.read(), HttpStatus.OK);
	}
	
	// create UPDATE next use @PutMapping, http element and id
			@PutMapping("/updateplant/{id}")
			public ResponseEntity<Plants> update(@PathVariable Long id, @RequestBody Plants plant){
				return new ResponseEntity<Plants>( this.service.update(id, plant), HttpStatus.ACCEPTED);
			}
			
//			create DELETE next use @DelteMapping, http element and id
			@DeleteMapping("/delete/{id}")
			public ResponseEntity<Boolean> delete(@PathVariable Long id){
				return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);
			}
	
			
	
}
