package com.qa.spring.garden.domain;


//import javax libraries
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity  //marks this class as a table

public class Plants {
	
//	declare variables
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String plantName;
	private String plantType;
	private boolean decorative;
	
	
//	add constructors
	
//	add empty constructor
	
	public Plants() {
	}
	
//	add constructors including id and without id
	
	public Plants(Long id, String plantName, String plantType, boolean decorative) {
		super();
		this.id = id;
		this.plantName = plantName;
		this.plantType = plantType;
		this.decorative = decorative;
	}
	
	public Plants(String plantName, String plantType, boolean decorative) {
		super();
		this.id = id;
		this.plantName = plantName;
		this.plantType = plantType;
		this.decorative = decorative;
	}
	
	
	
//	add getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getPlantType() {
		return plantType;
	}

	public void setPlantType(String plantType) {
		this.plantType = plantType;
	}

	public boolean isDecorative() {
		return decorative;
	}

	public void setDecorative(boolean decorative) {
		this.decorative = decorative;
	}
	
	

}
