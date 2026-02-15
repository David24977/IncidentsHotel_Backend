package com.David.IncidentsHotelBackend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.David.IncidentsHotelBackend.dto.incident.IncidentRequestDto;
import com.David.IncidentsHotelBackend.dto.incident.IncidentResponseDto;
import com.David.IncidentsHotelBackend.dto.incident.UpdateIncidentStatusRequest;
import com.David.IncidentsHotelBackend.service.IncidentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hotels/{hotelId}/incidents")
public class IncidentController {
	
	private final IncidentService incidentService;
	
	@GetMapping
	public List<IncidentResponseDto> findAllByHotelId(@PathVariable UUID hotelId){
		
		return incidentService.findAllByHotelId(hotelId);
	}
	
	
	@GetMapping("/{id}")
	public IncidentResponseDto findById(UUID hotelId, UUID id) {
		
		return incidentService.findById(hotelId, id);
	}
	
	@PostMapping
	public IncidentResponseDto createIncident(@PathVariable UUID hotelId, @RequestBody IncidentRequestDto incidentRequestDto) {
		
		return incidentService.createIncident(hotelId, incidentRequestDto);
	}
	
	@PatchMapping("/{id}")
	public IncidentResponseDto updateStatusIncident(@PathVariable UUID hotelId, @PathVariable UUID id, @RequestBody UpdateIncidentStatusRequest statusRequest) {
		
		return incidentService.updateStatusIncident(hotelId, id, statusRequest);
	}
	
	@DeleteMapping("/{id}")
	public void deleteIncident(@PathVariable UUID hotelId, @PathVariable UUID id) {
		
		incidentService.deleteIncident(hotelId, id);
	}
	
}
