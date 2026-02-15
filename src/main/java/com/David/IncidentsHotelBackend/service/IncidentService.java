package com.David.IncidentsHotelBackend.service;

import java.util.List;
import java.util.UUID;

import com.David.IncidentsHotelBackend.dto.incident.IncidentRequestDto;
import com.David.IncidentsHotelBackend.dto.incident.IncidentResponseDto;
import com.David.IncidentsHotelBackend.dto.incident.UpdateIncidentStatusRequest;

public interface IncidentService {
	
	List<IncidentResponseDto> findAllByHotelId(UUID hotelId);
	
	IncidentResponseDto findById(UUID hotelId, UUID id);
	
	IncidentResponseDto createIncident(UUID hotelId, IncidentRequestDto incidentRequestDto);
	
	IncidentResponseDto updateStatusIncident(UUID hotelId, UUID id, UpdateIncidentStatusRequest statusRequest);
	
	void deleteIncident(UUID hotelId, UUID id);

}

