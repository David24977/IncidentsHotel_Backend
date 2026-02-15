package com.David.IncidentsHotelBackend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.David.IncidentsHotelBackend.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, UUID>{
	
	
	
	boolean existsById(UUID id);
	
	

}

