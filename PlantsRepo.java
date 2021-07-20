package com.qa.spring.garden.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.spring.garden.domain.Plants;

@Repository

public interface PlantsRepo extends JpaRepository<Plants, Long>{
	
	
}
