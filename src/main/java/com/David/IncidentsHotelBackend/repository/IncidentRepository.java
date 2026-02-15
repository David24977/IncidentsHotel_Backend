package com.David.IncidentsHotelBackend.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.David.IncidentsHotelBackend.model.Incident;
import com.David.IncidentsHotelBackend.model.StatusIncident;

public interface IncidentRepository extends JpaRepository<Incident, UUID>{
	
	List<Incident> findAllByHotel_Id(UUID hotelId);
	
	Optional<Incident> findByIdAndHotel_Id(UUID id, UUID hotelId);
	
	boolean existsByIdAndHotel_Id(UUID id, UUID hotelId);
	
	List<Incident> findByHotel_IdAndStatus(UUID hotelId, StatusIncident status);

}