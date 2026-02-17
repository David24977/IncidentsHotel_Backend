package com.David.IncidentsHotelBackend.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.David.IncidentsHotelBackend.dto.incident.IncidentRequestDto;
import com.David.IncidentsHotelBackend.dto.incident.IncidentResponseDto;
import com.David.IncidentsHotelBackend.dto.incident.UpdateIncidentStatusRequest;
import com.David.IncidentsHotelBackend.exception.BadRequestException;
import com.David.IncidentsHotelBackend.exception.ResourceNotFoundException;
import com.David.IncidentsHotelBackend.model.Hotel;
import com.David.IncidentsHotelBackend.model.Incident;
import com.David.IncidentsHotelBackend.model.StatusIncident;
import com.David.IncidentsHotelBackend.repository.HotelRepository;
import com.David.IncidentsHotelBackend.repository.IncidentRepository;
import com.David.IncidentsHotelBackend.service.IncidentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IncidentServiceImpl implements IncidentService{
	
	private final HotelRepository hotelRepository;
	
	private final IncidentRepository incidentRepository;
	
	
	@Override
	public List<IncidentResponseDto> findAllByHotelId(UUID hotelId) {
		
		return incidentRepository.findAllByHotel_Id(hotelId)
				.stream()
				.map(this::mapIncidentResponseDto)
				.toList();
	}
	

	@Override
	public IncidentResponseDto findById(UUID hotelId, UUID id) {
		
		Incident incident = incidentRepository.findByIdAndHotel_Id(id, hotelId)
				.orElseThrow(()-> new ResourceNotFoundException("Incident not found"));
		
		return mapIncidentResponseDto(incident);
		}

	@Override
	public IncidentResponseDto createIncident(UUID hotelId, 
			IncidentRequestDto incidentRequestDto) {
		
		Hotel hotel = hotelRepository.findById(hotelId)
				.orElseThrow(()-> new ResourceNotFoundException("Hotel Not found"));
		
		Incident incident = new Incident();
		
		incident.setHotel(hotel);
		incident.setRoomNumber(incidentRequestDto.roomNumber());
		incident.setReportIncident(incidentRequestDto.reportIncident());
		incident.setCreatedByUserId(incidentRequestDto.createdByUserId());
		incident.setAssignedToUserId(incidentRequestDto.assignedToUserId());
		
		Incident savedIncident = incidentRepository.save(incident);
		
		return mapIncidentResponseDto(savedIncident);
	}
	
	
	@Override
	public IncidentResponseDto updateStatusIncident(UUID hotelId, UUID id, UpdateIncidentStatusRequest statusRequest)  {
		
		Incident incident = incidentRepository.findByIdAndHotel_Id(id, hotelId)
				.orElseThrow(()-> new ResourceNotFoundException("Incident not found"));
		
		if(statusRequest.status() == null) {
			throw new BadRequestException("Status is mandatory");
		}
		
		if (incident.getStatus() == statusRequest.status()) {
		    return mapIncidentResponseDto(incident);
		}
		
		if(incident.getStatus() == StatusIncident.IN_PROGRESS && 
				statusRequest.status() != StatusIncident.CLOSED) {
			
			throw new BadRequestException("Status can´t be open, it must be closed");
		}
		
		if(incident.getStatus() == StatusIncident.CLOSED) {
			
			throw new BadRequestException("Closed incident cannot be modified");
		}
		
		incident.setStatus(statusRequest.status());
		
		
		Incident updateIncident = incidentRepository.save(incident);
		
		return mapIncidentResponseDto(updateIncident);
	}

	@Override
	public void deleteIncident(UUID hotelId, UUID id) {
		Incident incident = incidentRepository.findByIdAndHotel_Id(id, hotelId)
				.orElseThrow(()-> new ResourceNotFoundException("Incident not found"));
		
		incidentRepository.delete(incident);
		
	}
	
	private IncidentResponseDto mapIncidentResponseDto(Incident incident) {
		
		return new IncidentResponseDto(
				
				incident.getId(),
				incident.getHotel().getId(),
				incident.getRoomNumber(),
				incident.getReportIncident(),
				incident.getStatus(),
				incident.getCreatedByUserId(),
				incident.getAssignedToUserId(),
				incident.getCreatedAt()
				);
		}

}